package com.program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

//  @GetMapping("")
//  public Object index() {
//    return "Hello World  Spring Boot Dev  Tools";
//  }
  @GetMapping("")
  public Object index() {
    return "view/index";
  }
}
