package com.curso.webapp.webapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    Map<String, Object> body = new HashMap<>();
    body.put("title", "Hola Mundo Spring Boot");
    body.put("name", "David");
    body.put("lastname", "Hernandez");

    return body;
  }

}
