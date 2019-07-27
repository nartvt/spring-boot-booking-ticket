package com.program.authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

  
  private static final String SECRET_KEY_STRING="SecretKeyToGenJWT";
  private final String TOKEN_PREFIXS= "Brearer";
  private final String HEADER_STRING="Authorization";
  private UserDetailsService userDetailsService;
  
  public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
      UserDetailsService userDetailsService) {
    super(authenticationManager);
    this.userDetailsService = userDetailsService;
  }
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
      String header = response.getHeader(HEADER_STRING);
      if(header==null||!header.startsWith(TOKEN_PREFIXS)) {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Please Sign in");
        response.getWriter().close();
        chain.doFilter(request, response);
        return;
      }
      UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      chain.doFilter(request, response);
  }
  
  private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if(token==null) return null;
    String userName = Jwts.parser()
        .setSigningKey(SECRET_KEY_STRING)
        .parseClaimsJws(token.replace(TOKEN_PREFIXS,""))
        .getBody()
        .getSubject();
    
    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
    return userName!=null?new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities()):null;
  }

  
}
