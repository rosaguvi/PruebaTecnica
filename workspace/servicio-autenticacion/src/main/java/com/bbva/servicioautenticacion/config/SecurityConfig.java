package com.bbva.servicioautenticacion.config;


import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Value("${spring.security.jwt.clave.usuario}")
    private String claveUsuario;

    // Definimos usuarios en memoria para autenticación
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails usuario = User.withUsername("usuario")
                .password("{noop}" + claveUsuario)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(usuario);
    }

    // Exponemos el bean de AuthenticationManager usando AuthenticationConfiguration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Configuración de seguridad mediante SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic(withDefaults());
        
        return http.build();
    }
}
