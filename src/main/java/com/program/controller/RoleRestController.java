package com.program.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
  public @ResponseBody List<RoleDTO> roleMany() {
    List<RoleDTO> roles = roleService.findAll();
    return roles;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody RoleDTO roleOne(@PathVariable("id") Long roleId) {
    RoleDTO role = roleService.findById(roleId);
    return role;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public ResponseEntity<Object> createRole(@RequestBody RoleDTO model) {
    ResponseExceptionModel response  = roleService.insert(model);
    if (status == false) {
      return ResponseEntity.notFound().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RestContant.REST_BY_ID)
        .buildAndExpand(model.getRoleId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public ResponseEntity<Object> updateRole(@RequestBody RoleDTO model) {
    RoleDTO roleOptional = roleService.findById(model.getRoleId());
    if (roleOptional == null) {
      return ResponseEntity.notFound().build();
    }
    roleService.update(model);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Long roleId) {
    Map<String, Boolean> response = new HashMap<String, Boolean>();
    ResponseExceptionModel  responseException = roleService.delete(roleId);

    if (isDeleteStatus == false) {
      response.put("undeleted", isDeleteStatus);
      return response;
    }
    response.put("deleted", isDeleteStatus);
    return response;
  }
}
