package com.primerapirest.primerapirest.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primerapirest.primerapirest.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.primerapirest.primerapirest.security.TokenJwtConfig.*;

// Crear el token: -> Hacer Login.

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;


  public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
   this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    User user = null;
    String username = null;
    String password = null;

    try {
      user = new ObjectMapper().readValue(request.getInputStream(), User.class);
      username = user.getUsername();
      password = user.getPassword();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
    return authenticationManager.authenticate(authenticationToken);
  }

  // Creación del token en caso de que el acceso sea correcto.
  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
    String username = user.getUsername();
    Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();

    Claims claims = Jwts.claims().add("authorities", new ObjectMapper().writeValueAsString(roles)).build();

    String token = Jwts.builder()
        .subject(username)
        .claims(claims)
        .expiration(new Date(System.currentTimeMillis() + 3600000)) // Fecha actual más 1 hora. -> Esto es el tiempo en el que expira el token.
        .issuedAt(new Date())
        .signWith(SECRET_KEY)
        .compact();

    response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);
    Map<String, String> body = new HashMap<>();
    body.put("Token: ", token);
    body.put("Username: ", username);
    body.put("Message: ", String.format("Hola %s, has iniciado sesión con éxito.", username));

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setContentType(CONTENT_TYPE);
    response.setStatus(200);
  }

  // Mensajes en caso de que el acceso sea incorrecto.
  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
    Map<String, String> body = new HashMap<>();

    body.put("Message:", "Error en la autenticación: Username o password incorrectos!.");
    body.put("Error: ", failed.getMessage());

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    response.setStatus(401);
    response.setContentType(CONTENT_TYPE);
  }
}
