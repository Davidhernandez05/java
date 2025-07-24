package com.error.springboot_error.exceptions;

public class UserNorFoundException extends RuntimeException {
  public UserNorFoundException (String message) {
    super(message);
  }
}
