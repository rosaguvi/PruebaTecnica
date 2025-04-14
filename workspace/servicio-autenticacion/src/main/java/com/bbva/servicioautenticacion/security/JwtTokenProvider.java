package com.bbva.servicioautenticacion.security;

import io.jsonwebtoken.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Clave secreta para firmar el token (debe mantenerse segura)
    @Value("${spring.security.jwt.jwtFilter.secret}")
    private String secretKey;
    
    // Tiempo de expiración: 1 hora (en milisegundos)
    private final long JWT_EXPIRATION = 3600000;

    // Genera el token a partir del username
    public String generarToken(String username) {
        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + JWT_EXPIRATION);
        
        return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(fechaActual)
                   .setExpiration(fechaExpiracion)
                   .signWith(SignatureAlgorithm.HS512, secretKey)
                   .compact();
    }

    // Extrae el nombre de usuario del token
    public String obtenerUsername(String token) {
        Claims claims = Jwts.parser()
                             .setSigningKey(secretKey)
                             .parseClaimsJws(token)
                             .getBody();
        return claims.getSubject();
    }

    // Valida el token y atrapa posibles excepciones
    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Firma JWT inválida");
        } catch (MalformedJwtException ex) {
            System.out.println("Token JWT mal formado");
        } catch (ExpiredJwtException ex) {
            System.out.println("Token JWT expirado");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Token JWT no soportado");
        } catch (IllegalArgumentException ex) {
            System.out.println("Claims JWT vacíos");
        }
        return false;
    }
}