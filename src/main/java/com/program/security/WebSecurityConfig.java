package com.program.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.program.authentication.JWTAuthenticationFilter;
import com.program.authentication.JWTAuthorizationFilter;


 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private UserDetailsService userDetailService;

  
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

   
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
  }

 
  protected void configure(HttpSecurity http) throws Exception {
    http.cors();
    http.csrf()
    .disable()
    .authorizeRequests()
    .antMatchers("/api/*")
    .authenticated();

    http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
    http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailService));
  }

}
