package com.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.program.dto.UserDTO;
import com.program.service.UserService;

@Controller
@RequestMapping("/rest/user/")
public class UserController {
  
  private static final String VIEW_USER_INDEX = "view/user/index";
  
  @Autowired
  private UserService userService;

  @GetMapping("")
  public String index(ModelMap modelMap) {
    final List<UserDTO> usersDtos = userService.findAll();
    modelMap.addAttribute("users", usersDtos);
    return VIEW_USER_INDEX;
    
  }
}
