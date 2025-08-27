package com.primerapirest.primerapirest.security;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// Aquí configuramos todo lo relacionado a Spring Security:
@Configuration
public class SpringSecurityConfig {

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // Al hacer esto nos da acceso publico a todo lo que esta en la URL indicada.
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
        authz -> authz
            .requestMatchers(HttpMethod.GET, "/users").permitAll() // Le indicamos que el método get users es público. -> Todos tienen acceso.
            .requestMatchers(HttpMethod.POST, "/users/register").permitAll()// Le indicamos que el método post register el publico. -> Todos tienen acceso.
            .anyRequest()
            .authenticated()
    ).csrf(config -> config.disable()) // Se deshabilita para habitar invulnerabilidades.
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
  }
}
