package com.error.springboot_error.Controllers;

import com.error.springboot_error.exceptions.UserNorFoundException;
import com.error.springboot_error.models.domain.User;
import com.error.springboot_error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

  @Autowired
  private UserService service;

  @GetMapping
  public String index() {
    //var division = 100 / 0;
    int value = Integer.parseInt("H0L4");
    return "Ok 200";
  }

  @GetMapping("/show")
  public List<User> listUsers() {
    return service.findAll();
  }

  @GetMapping("/show/{id}")
  public User show(@PathVariable Long id) {
    User user = service.findById(id).orElseThrow(() -> new UserNorFoundException("El usuario no existe"));

    return user;
  }
}
