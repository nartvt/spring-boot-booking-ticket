package com.program.dto;

import org.mindrot.jbcrypt.BCrypt;

import com.program.entity.RoleEntity;
import com.program.entity.UserEntity;

public class UserDTO {
  private Long userId;

  private String userName;

  private String email;

  private String password;

  private String address;

  private String phoneNumber;

  private String avatar;

  private Long role;

  public UserDTO() {

  }

  public UserDTO(final UserEntity entity) {
    this.userId = entity.getUserId();
    this.userName = entity.getUserName();
    this.email = entity.getEmail();
    this.password = entity.getPassword();
    this.address = entity.getAddress();
    this.phoneNumber = entity.getPhoneNumber();
    this.avatar = entity.getAvatar();
    if(entity.getRole().getRoleId()!=null) {
      this.role = entity.getRole().getRoleId();
    }
  }

  public UserEntity convert() {
    final UserEntity entity = new UserEntity();
    entity.setUserId(this.userId);
    entity.setUserName(this.userName);
    entity.setEmail(this.email);
    entity.setPassword(BCrypt.hashpw(this.password, BCrypt.gensalt(12)));
    entity.setAddress(this.address);
    entity.setPhoneNumber(this.phoneNumber);
    entity.setAvatar(this.avatar);
    RoleEntity roleEntity = new RoleEntity();
    roleEntity.setRoleId(this.role);
    if (this.role != null) {
      entity.setRole(roleEntity);
    }
    return entity;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
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

  public Long getRole() {
    return role;
  }

  public void setRole(Long role) {
    this.role = role;
  }
}
