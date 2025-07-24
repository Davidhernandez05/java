package com.error.springboot_error.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/app")
  public String index() {
    return "Ok 200";
  }
}
