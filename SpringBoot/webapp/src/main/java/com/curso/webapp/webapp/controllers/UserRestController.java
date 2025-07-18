package com.curso.webapp.webapp.controllers;


import com.curso.webapp.webapp.models.DTO.UserDto;
import com.curso.webapp.webapp.models.DTO.UserDto2;
import com.curso.webapp.webapp.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api") // Esto es como una ruta base lo que quiere decir que todo lo que este en este método siempre tiene que llevar el /api antes de GET.
public class UserRestController {

  @GetMapping("holaMundo")
  public String hola() {
    return "Hola Mundo";
  }

  @GetMapping("/primerApi")
  public Map<String, Object> firstApiRestController() {

    //Estó nos retornaría algo asi como una estructura de JSON:
    User user1 = new User("David", "Hernandez");
    Map<String, Object> body = new HashMap<>();
    body.put("title", "Hola Mundo Spring Boot");
    body.put("user", user1);
    // body.put("name", "David");
    // body.put("lastname", "Hernandez");
    return body;
  }

  @GetMapping("/api-dto")
  public UserDto apidto() {

    UserDto userDto = new UserDto();
    User user = new User("Miguel", "Mou");

    userDto.setUser(user);
    userDto.setTitle("Hola Mundo.");

    return userDto;

    //Esta es otra forma de hacer esto mismo.
    //UserDto2 userDto2 = new UserDto2();
    //userDto2.setTitle("Hola Mundo.");
    //userDto2.setName(user.getName().concat(" ").concat(user.getLastname()));


  }

}
