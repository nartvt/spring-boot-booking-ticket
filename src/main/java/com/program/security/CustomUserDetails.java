package com.program.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {
  private static final long serialVersionUID = 1L;
  private String fullName;
  private String avatar;

  public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);

  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

}
