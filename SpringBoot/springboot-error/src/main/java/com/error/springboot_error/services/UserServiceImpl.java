package com.error.springboot_error.services;

import com.error.springboot_error.models.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired()
  private List<User> users;

  @Override
  public List<User> findAll() {
    return users;
  }

  @Override
  public Optional<User> findById(Long id) {

    return users.stream().filter( usr -> usr.getId().equals(id)).findFirst();

    //for (User u : users) {
    //  if (u.getId().equals(id)) {
    //    return Optional.of(u);
    //  }
    //}
    //return Optional.ofNullable(user);

  }
}
