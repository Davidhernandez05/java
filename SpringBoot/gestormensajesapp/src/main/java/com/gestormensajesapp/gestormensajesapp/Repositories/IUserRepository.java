package com.gestormensajesapp.gestormensajesapp.Repositories;

import com.gestormensajesapp.gestormensajesapp.Models.User;

import java.util.List;

public interface IUserRepository {
  List<User> findAll();
  User findId(Integer id);
  String greetEnglish(User user);
  String greetSpanish(User user);
  String greetFrench(User user);

}
