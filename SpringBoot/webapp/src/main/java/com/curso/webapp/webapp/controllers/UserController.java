package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) { // Se puede utilizar el model o también el MAP clasico de java: Si utilizas el MAP se agregan los datos con PUT.

    User user = new User("David", "Hernandez");
    model.addAttribute("title", "Hola mundo Spring Boot"); //Clave - valor.
    //model.addAttribute("User: ", user);
    model.addAttribute("name", "David");
    model.addAttribute("lastname", "Hernandez");

    return "details"; //Este nombre tiene que concordar con el nombre de templates para que llame al archivo html.
  }

  @GetMapping("/list")
  public String list(ModelMap model) {

    var users = new ArrayList<User>();
    model.addAttribute("title", "Listado de usuarios:");
    model.addAttribute("User", users);

    return "lista";
  }
}
