package com.curso.webapp.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({"", "/", "/home"})
  public String home() {

    //return "redirect:/list"; //Esto es lo más típico en un CRUD.
    return "forward:/list";
  }
}
