package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  // Buscar Datos en la BD:
  List<User> findAll();
  Optional<User> findById(Integer id);

  // Realizar operaciones en la BD:
  User save(User user);
  Optional<User> update(Integer id, User user);
  Optional<User> delete(Integer id);

}
