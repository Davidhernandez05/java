package com.primerapirest.primerapirest.services;

import com.primerapirest.primerapirest.entities.User;

import java.util.List;

public interface UserService {

  List<User> findAll();
  User save(User user);
}
