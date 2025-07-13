package com.holamundo.primeraApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Nuestro primer controlador.
@RestController
//Request es una solicitud que se puede recibir desde un cliente.
@RequestMapping("/n") //Esto hace que antes de llamar en este caso él hola tengamos que llamar apisaludos en la URL.
public class SaludosController {

  // Creación Endpoint: método que tiene una URL que va a responder algo.
  @GetMapping("/hola") //Mapeo de GET -> Se utiliza cuando vamos a utilizar el método Get.
  public String holaMundo() {
    return "Hola Mundo.";
  }

  @GetMapping("/holaname/{nombre}/{edad}") //Con PathVariable: Le decimos que los parámetros se envían por la url
  public String holaMundoNombre(@PathVariable String nombre, @PathVariable int edad) {
    return "Hola: " + nombre + " tu edad es: " + edad;
  }
}
