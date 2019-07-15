package com.program.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.program.entity.RoleEntity;

public class RoleDTO {

  private Long roleId;

  @NotBlank(message = "Role Name cannot be NULL")
  private String roleName;

  @NotBlank(message = "Role description cannot be NULL")
  private String description;

  public Set<UserDTO> users;

  public RoleDTO() {

  }

  public RoleDTO(final RoleEntity entity) {
    this.roleId = entity.getRoleId();
    this.roleName = entity.getRoleName();
    this.description = entity.getDescription();
  }

  public RoleEntity convert() {
    final RoleEntity entity = new RoleEntity();
//    entity.setRoleId(this.roleId);
    entity.setRoleName(this.roleName);
    entity.setDescription(this.description);
    return entity;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<UserDTO> getUsers() {
    return users;
  }

  public void setUsers(Set<UserDTO> users) {
    this.users = users;
  }

}
