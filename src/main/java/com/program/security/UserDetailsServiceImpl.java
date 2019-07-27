package com.program.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.program.entity.UserEntity;
import com.program.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity user = userRepository.findByEmail(email);
    Collection<GrantedAuthority> authorities = Lists.newArrayList();
    authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
    CustomUserDetails customUserDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), authorities);
    customUserDetails.setFullName(email);
    customUserDetails.setAvatar(user.getAvatar());
    return customUserDetails;
  }

}
