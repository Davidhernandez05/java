package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.User;
import com.ejercicio.to_dolist.to_do.list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
  public Optional<User> findById(Integer id) {
    return userRepository.findById(id);
  }

  @Transactional
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public Optional<User> update(Integer id, User user) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      User userDB = optionalUser.orElseThrow();

      userDB.setName(user.getName());
      userDB.setLastname(user.getLastname());
      userDB.setEmail(user.getEmail());

      System.out.println("Se actualizo correctamente el usuario.");

      return Optional.of(userRepository.save(userDB));
    }
    return optionalUser;
  }

  @Transactional
  @Override
  public Optional<User> delete(Integer id) {
    Optional<User> optionalUser = userRepository.findById(id);

    optionalUser.ifPresentOrElse(user -> {
      userRepository.delete(user);
      System.out.println("Se elimino correctamente el usuario: " + user);

    }, () -> System.out.println("El usuario no existe."));

    return optionalUser;
  }
}
