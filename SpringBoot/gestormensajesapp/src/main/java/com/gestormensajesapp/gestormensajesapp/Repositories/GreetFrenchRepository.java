package com.gestormensajesapp.gestormensajesapp.Repositories;

import com.gestormensajesapp.gestormensajesapp.Models.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("french")
public class GreetFrenchRepository implements IUserRepository {
  private List<User> userList;

  public GreetFrenchRepository() {
    this.userList = Arrays.asList(
        new User(1, "Jack", "Hernandez", 28),
        new User(2, "Max", "Hernandez", 28),
        new User(3, "Suzie", "Torres", 28),
        new User(4, "Gohan", "Kakaroto", 28)
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
    return "";
  }

  @Override
  public String greetSpanish(User user) {
    return "";
  }

  @Override
  public String greetFrench(User user) {
    return "Bonjour, " + user.getName() + " " + user.getLastname();
  }
}
