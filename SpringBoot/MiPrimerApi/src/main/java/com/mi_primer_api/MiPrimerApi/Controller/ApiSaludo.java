package com.mi_primer_api.MiPrimerApi.Controller;

import com.mi_primer_api.MiPrimerApi.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiSaludo {

  @GetMapping("/saludo")
  public String saludo() {
    return "Este es mi permer saludo en Spring Boot";
  }

  @PostMapping("saludo")
  public String saludarConNombre(@RequestBody Persona persona) {
    // Transforma los datos Json al contexto por así decirlo de java para que este entienda los datos.
    return "Hola! " + persona.getName() + "!.";
  }

}
