package com.gestormensajesapp.gestormensajesapp.Services;

import com.gestormensajesapp.gestormensajesapp.Models.User;
import com.gestormensajesapp.gestormensajesapp.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// El service es donde trabajamos con los datos.
@Service
public class UserServices implements IUserServices {

  private IUserRepository repository;

  public UserServices(@Qualifier("french") IUserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  public User findId(Integer id) {
    return repository.findId(id);
  }

  @Override
  public String greetEnglish(User user) {
    return repository.greetEnglish(user);
  }

  @Override
  public String greetSpanish(User user) {
    return repository.greetSpanish(user);
  }

  @Override
  public String greetFrench(User user) {
    return repository.greetFrench(user);
  }

}
