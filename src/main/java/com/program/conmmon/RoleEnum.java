package com.program.conmmon;

public enum RoleEnum {
  ROLE_ADMIN(1,"ROLE_ADMIN"),
  ROLE_USER(2,"ROLE_USER"),
  ROLE_STAFF(3,"ROLE_STAFF");
  
  private long id;
  private String name;
  
  private RoleEnum(long id,String name) {
  this.id = id;
  this.name = name;
  }
  
  public long ID() {
    return this.id;
  }
  
  public String NAME() {
    return this.name;
  }
  
}
