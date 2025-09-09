package com.primerapirest.primerapirest.controllers;

import com.primerapirest.primerapirest.entities.User;
import com.primerapirest.primerapirest.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = "*", origins = "http://localhost:4200") // -> Cors -> Dar acceso a nuestro backend.
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> users(){
    return userService.findAll();
  }

  @PreAuthorize("hasRole('ADMIN')") // Esto da permisos solo al administrador en lugar de hacerlo desde security.
  @PostMapping
  public ResponseEntity<?> save(@Valid @RequestBody User user, BindingResult result) {

    if (result.hasFieldErrors()){
      return validation(result);
    }

    user.setAdmin(false);
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
    user.setAdmin(false);
    return save(user, result);
  }


  // Nos retorna un mensaje para el usuario en caso de que se genere algún error al momento de ingresar los datos.
  private ResponseEntity<?> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();

    result.getFieldErrors().forEach(error -> {
      errors.put(error.getField(), "El campo: " + error.getField() + " " + error.getDefaultMessage());

      // error.getField() -> Nos da el nombre del campo.
      // error.getDefaultMessage() -> Nos da el mensaje de error.
    });

    return ResponseEntity.badRequest().body(errors);
  }
}
