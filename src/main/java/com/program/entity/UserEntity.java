package com.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "User")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private Long userId;

  @Column(name = "userName")
  private String userName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "address")
  private String address;

  @Column(name = "phoneNumber")
  private String phoneNumber;

  @Column(name = "avatar")
  private String avatar;


  @JsonIgnore
  @OneToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "UserRole",
  joinColumns = @JoinColumn(name="userId",referencedColumnName = "userId",unique = true ),
  inverseJoinColumns = @JoinColumn(name="roleId",referencedColumnName = "roleId"))
  private RoleEntity role;

  
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

  public RoleEntity getRole() {
    return role;
  }

  public void setRole(RoleEntity role) {
    this.role = role;
  }

}
