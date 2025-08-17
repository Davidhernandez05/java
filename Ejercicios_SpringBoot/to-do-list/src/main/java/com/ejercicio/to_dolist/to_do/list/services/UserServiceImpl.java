package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.User;
import com.ejercicio.to_dolist.to_do.list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Transactional(readOnly = true)
  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public ResponseEntity<?> findById(Integer id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      User user = optionalUser.get();

      return ResponseEntity.ok().body(user);
    }

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún usuario existente con el ID: " + id));
  }

  @Transactional
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public ResponseEntity<?> update(Integer id, User user) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      User userDB = optionalUser.orElseThrow();

      userDB.setName(user.getName());
      userDB.setLastname(user.getLastname());
      userDB.setEmail(user.getEmail());

      System.out.println("Se actualizo correctamente el usuario.");
      return ResponseEntity.ok().body(userRepository.save(userDB));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ningún usuario con el ID: " + id));
  }

  @Transactional
  @Override
  public ResponseEntity<?> delete(Integer id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      userRepository.delete(user);

      return ResponseEntity.ok().body(Map.of("Mensaje: ", "Se elimino correctamente el usuario con ID: " + id));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje:", "No se encontró ninguna usuario con el ID: " + id));
  }
}
