package com.gestormensajesapp.gestormensajesapp.Repositories;


import com.gestormensajesapp.gestormensajesapp.Models.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

// Se utiliza cuando trabajamos con los datos, ejemplo Bases de datos SQL y no SQL, etc.
@Repository
@Primary
public class UserRepository implements IUserRepository {
    private List<User> userList;

    public UserRepository() {
      this.userList = Arrays.asList(
          new User(1, "David", "Hernandez", 28),
          new User(2, "Alejandra", "Hernandez", 28),
          new User(3, "Andres", "Torres", 28),
          new User(4, "Goku", "Kakaroto", 28)
      );
    }


  @Override
  public List<User> findAll() {
    return userList;
  }

  @Override
  public User findId(Integer id) {
    return userList.stream()
        .filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
  }

  @Override
  public String greetEnglish(User user) {
    return "Hello, " + user.getName();
  }

  @Override
  public String greetSpanish(User user) {
    return "Hola, " + user.getName() + " " + user.getLastname();
  }

  @Override
  public String greetFrench(User user) {
    return "Bonjour, " + user.getName() + " " + user.getLastname();
  }
}
