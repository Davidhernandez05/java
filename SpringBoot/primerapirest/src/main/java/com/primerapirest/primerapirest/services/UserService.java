package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {

  List<User> findAll();
  User save(User user);

  Boolean existsByUsername(String username);
}
