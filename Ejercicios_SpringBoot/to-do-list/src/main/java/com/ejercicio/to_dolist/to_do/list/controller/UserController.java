package com.ejercicio.to_dolist.to_do.list.controller;

import com.ejercicio.to_dolist.to_do.list.entities.User;
import com.ejercicio.to_dolist.to_do.list.services.UserService;
import com.ejercicio.to_dolist.to_do.list.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService service;

  // Listamos todos los usuarios que hay en la BD.
  @GetMapping()
  public List<User> list() {
    return ResponseEntity.ok(service.findAll()).getBody();
  }

  // Creamos un usuario nuevo.
  @PutMapping()
  public ResponseEntity<?> create(@Valid @RequestBody User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
  }


  @GetMapping("/{id}")
  public ResponseEntity<?> view (@PathVariable Integer id) {
    Optional<User> optionalUser = service.findById(id);

    if (optionalUser.isPresent()){
      return ResponseEntity.ok().body(optionalUser.orElseThrow());
    }

    // Creamos un mensaje desde aquí en caso de que no se encuentre el ID en la BD.
    Map<String, String> respuesta = new HashMap<>();
    respuesta.put("Mensaje: ", "No se encontró ningún usuario con el id " + id + ".");
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
  }
}
