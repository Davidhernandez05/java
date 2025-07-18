package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimerPost {

  @PostMapping("/created")
  public String created(@RequestBody User user) {
    return "Se creo el usuario: " + user.getName() + " " + user.getLastname();
  }
}
