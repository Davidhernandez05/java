package com.aop.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {


  @Override
  public String sayHello(String person, String phrase) {
    return phrase + " " + person;
  }

  @Override
  public String sayHelloError(String person, String phrase) {
    throw new RuntimeException("Algo salio mal.");
  }
}
