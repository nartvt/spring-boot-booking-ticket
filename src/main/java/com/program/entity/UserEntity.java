package com.program.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "User")
public class UserEntity {
  @Id
  private String userId;
  private String userName;
  private String email;
  private String password;
  private String address;
  private String phoneNumber;
  private String avatar;
  
  
  @OneToMany(mappedBy = "user")
  private Set<PermissionEntity> permissions;


  public String getUserId() {
    return userId;
  }


  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }


  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getAddress() {
    return address;
  }


  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getAvatar() {
    return avatar;
  }


  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public Set<PermissionEntity> getPermissions() {
    return permissions;
  }


  public void setPermissions(Set<PermissionEntity> permissions) {
    this.permissions = permissions;
  }
  
  
}
