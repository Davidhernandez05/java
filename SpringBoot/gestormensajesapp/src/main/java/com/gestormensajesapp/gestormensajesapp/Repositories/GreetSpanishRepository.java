package com.gestormensajesapp.gestormensajesapp.Repositories;

import com.gestormensajesapp.gestormensajesapp.Models.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("spanish")
public class GreetSpanishRepository implements IUserRepository {
  private List<User> userList;

  public GreetSpanishRepository() {
    this.userList = Arrays.asList(
        new User(1, "Ricardo", "Hernandez", 28),
        new User(2, "Michell", "Hernandez", 28),
        new User(3, "Erika", "Torres", 28),
        new User(4, "Vegenta", "Kakaroto", 28)
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
    return "Valor no valido en el momento.";
  }

  @Override
  public String greetSpanish(User user) {
    return "Hola, " + user.getName() + " " + user.getLastname();
  }

  @Override
  public String greetFrench(User user) {
    return "Valor no valido en el momento.";
  }
}
