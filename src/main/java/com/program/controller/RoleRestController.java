package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.conmmon.RestContant;
import com.program.dto.RoleDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.RoleService;

@RestController
@RequestMapping("/rest/api/role")
public class RoleRestController {

  @Autowired
  private RoleService roleService;

  @GetMapping(value = RestContant.REST_ALL)
  public List<RoleDTO> roleMany() {
    List<RoleDTO> roles = roleService.findAll();
    return roles;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public RoleDTO roleOne(@PathVariable("id") Long roleId) {
    RoleDTO role = roleService.findById(roleId);
    return role;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createRole(@RequestBody RoleDTO model) {
    ResponseExceptionModel responseException = roleService.insert(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateRole(@RequestBody RoleDTO model) {
    ResponseExceptionModel responseException = roleService.update(model);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Long roleId) {
    ResponseExceptionModel responseException = roleService.delete(roleId);
    return new ResponseEntity<>(responseException, responseException.getHttpMessage());
  }
}
