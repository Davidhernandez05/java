package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ImportLists {

  @GetMapping("/usuarios")
  public List<User> listUsers() {
    User user1 = new User("David", "Hernandez");
    User user2 = new User("Maria", "Guzman");
    User user3 = new User("Alejandra", "Hernandez");

    //List<User> users = new ArrayList<>();
    //users.add(user1);
    //users.add(user2);
    //users.add(user3);

    return Arrays.asList(user1, user2, user3); // Esto funciona igual que el anterior.
    // Tener en cuenta esto es solamente si conocemos los datos de lo contrario se debe hacer de la forma anterior (ArrayList) pero con un for.
  }

}
