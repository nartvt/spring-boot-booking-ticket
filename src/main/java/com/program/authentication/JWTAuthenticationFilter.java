package com.program.authentication;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.program.entity.UserEntity;
import com.program.security.CustomUserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private static final long EXPIRE_TIME = 864_000_000;
  private static final String SECRET_KEY = "SecretKeyToGenJWT";
  private final String TOKEN_PREFIXS = "Brearer";
  private final String HEADER_STRING = "Authorization";

  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    UserEntity user;
    try {
      user = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
      UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user.getEmail(),
          user.getPassword());
      Authentication auth = authenticationManager.authenticate(userToken);
      return auth;
    } catch (AuthenticationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    UserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();
    String token = Jwts.
        builder()
        .setSubject(userDetails.getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    response.addHeader(HEADER_STRING, TOKEN_PREFIXS + token);
    response.getWriter().write(TOKEN_PREFIXS + token);
    response.getWriter().close();
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    response.setStatus(401);
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("Wrong username or password");
    response.getWriter().close();
  }
}
