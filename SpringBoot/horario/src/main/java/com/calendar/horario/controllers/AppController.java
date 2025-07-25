package com.calendar.horario.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/app")
public class AppController {

  @GetMapping("/index")
  public ResponseEntity<?> index(HttpServletRequest request) { //Nos sirve para recibir el message que viene de calendar.

    Map<String, Object> data = new HashMap<>();
    data.put("tittle", "Bienvenidos al sistema de atención!.");
    data.put("date", new Date());
    data.put("message", request.getAttribute("message")); // Agregamos el message que traemos desde calendar al JSON que vamos a mostrar al usuario.

    return ResponseEntity.ok(data); //Imprimimos nuestro Map como un JSON.
  }
}
