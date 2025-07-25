package com.interceptor.interceptor_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {

  @GetMapping("/foo")
  public Map<String, String> foo() {
    return Collections.singletonMap("Message", "handler foo del controlador.");
  }

  @GetMapping("/bar")
  public Map<String, String> bar() {
    return Collections.singletonMap("Message", "handler bar del controlador.");
  }

  @GetMapping("/baz")
  public Map<String, String> baz() {
    return Collections.singletonMap("Message", "handler baz del controlador.");
  }
}
