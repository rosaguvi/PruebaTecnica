package com.bbva.servicioautenticacion.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bbva.servicioautenticacion.security.JwtTokenProvider;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    // Este servicio puede ser el InMemoryUserDetailsManager
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
			throws jakarta.servlet.ServletException, IOException {
        // Extrae el token de la cabecera Authorization
        String token = obtenerJWTdeSolicitud((HttpServletRequest) request);
        if (token != null && tokenProvider.validarToken(token)) {
            String username = tokenProvider.obtenerUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            
            // Establece la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    // Método para extraer el JWT del header Authorization
    private String obtenerJWTdeSolicitud(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}