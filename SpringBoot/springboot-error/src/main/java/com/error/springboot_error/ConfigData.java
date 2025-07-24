package com.error.springboot_error;

import com.error.springboot_error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigData {

  private List<User> users;

  @Bean
  List<User> Users() {
    this.users = new ArrayList<>();

    users.add(new User(1L, "David", "Hernandez"));
    users.add(new User(2L, "Pepe", "Gonzales"));
    users.add(new User(3L, "Andres", "De la Rosa"));
    users.add(new User(4L, "Francisco", "Math"));
    users.add(new User(5L, "Alejandra", "Hernandez"));

    return users;
  }

}
