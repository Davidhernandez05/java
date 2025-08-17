package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

  // Buscar Datos en la BD:
  List<User> findAll();
  ResponseEntity<?> findById(Integer id);

  // Realizar operaciones en la BD:
  User save(User user);
  ResponseEntity<?> update(Integer id, User user);
  ResponseEntity<?> delete(Integer id);

}
