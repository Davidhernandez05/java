package com.curso.webapp.webapp.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) { // Se puede utilizar el model o también el MAP clasico de java: Si utilizas el MAP se agregan los datos con PUT.

    model.addAttribute("title", "Hola mundo Spring Boot"); //Clave - valor.
    model.addAttribute("name", "David");
    model.addAttribute("lastname", "Hernandez");

    return "details"; //Este nombre tiene que concordar con el nombre de templates para que llame al archivo html.
  }
}
