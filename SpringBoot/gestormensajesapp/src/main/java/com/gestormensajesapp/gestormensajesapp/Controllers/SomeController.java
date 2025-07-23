package com.gestormensajesapp.gestormensajesapp.Controllers;

import com.gestormensajesapp.gestormensajesapp.Models.User;
import com.gestormensajesapp.gestormensajesapp.Services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SomeController {

  @Autowired
  private IUserServices services;

  @GetMapping("/users")
  public List<User> list() {
    return services.findAll();
  }

  @GetMapping("/user/{id}")
  public User show(@PathVariable int id) {
    return services.findId(id);
  }

  @GetMapping("greet/{id}")
  public String greetEnglish(@PathVariable Integer id) {
    return services.greetEnglish(services.findId(id));
  }

  @GetMapping("greet-es/{id}")
  public String greetSpanish(@PathVariable Integer id) {
    return services.greetSpanish(services.findId(id));
  }

  @GetMapping("/greet-fc/{id}")
  public String greetFrench(@PathVariable Integer id) {
    return services.greetFrench(services.findId(id));
  }
}
