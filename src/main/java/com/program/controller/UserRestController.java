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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.program.conmmon.RestContant;
import com.program.dto.UserDTO;
import com.program.error.ResponseExceptionModel;
import com.program.service.UserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserRestController {

  @Autowired
  private UserService userService;

  @GetMapping(value = RestContant.REST_ALL)
  public @ResponseBody List<UserDTO> users() {
    List<UserDTO> Users = userService.findAll();
    return Users;
  }

  @GetMapping(value = RestContant.REST_BY_ID)
  public @ResponseBody UserDTO user(@PathVariable("id") Long UserId) {
    UserDTO User = userService.findById(UserId);
    return User;
  }

  @PostMapping(value = RestContant.REST_ADD)
  public @ResponseBody ResponseEntity<Object> createUser(@RequestBody UserDTO model) {
    ResponseExceptionModel  responseException = userService.insert(model);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }

  @PutMapping(value = RestContant.REST_UPDATE)
  public @ResponseBody ResponseEntity<Object> updateUser(@RequestBody UserDTO model) {   
    ResponseExceptionModel  responseException  = userService.update(model);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }

  @DeleteMapping(value = RestContant.REST_DELETE_BY_ID)
  public @ResponseBody Object deleteUser(@PathVariable(value = "id") Long id) {
    ResponseExceptionModel  responseException = userService.delete(id);
    return new ResponseEntity<>(responseException,responseException.getHttpCode());
  }
}
