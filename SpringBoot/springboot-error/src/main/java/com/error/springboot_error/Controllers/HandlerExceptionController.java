package com.error.springboot_error.Controllers;

import com.error.springboot_error.exceptions.UserNorFoundException;
import com.error.springboot_error.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice // Identifica que es un controlador de error.
public class HandlerExceptionController {

  @ExceptionHandler(ArithmeticException.class) // El tipo de error que se podría generar.
  public ResponseEntity<Error> divisionByZero(Exception ex) {

    // Creamos el error con el models.
    Error error = new Error();
    error.setDate(new Date());
    error.setError("Error división por cero!.");
    error.setMessage(ex.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); //Imprime el error 500 como valor en el JSON.

    //return ResponseEntity.internalServerError().body(error); //Genera el error 500 en el servidor.
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error); // Se puede hacer de cualquiera de las dos formas.
  }


  // Nos permite modificar el mensaje de error del 404, pero se tiene que modificar también en el application.properties.
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error> notFountException(NoHandlerFoundException e) {

    Error error = new Error();
    error.setDate(new Date());
    error.setError("Api rest no encontrada.");
    error.setMessage(e.getMessage());

    error.setStatus(HttpStatus.NOT_FOUND.value());

    return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
  }

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //Genero el status de error en el servidor.
  public Map<String, Object> numberFormatException(Exception e) {

    Map<String, Object> error = new HashMap<>();

    error.put("date", new Date());
    error.put("error", "Numero no valido, formato incorrecto.");
    error.put("Message", e.getMessage());
    error.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    return error;
  }

  @ExceptionHandler({NullPointerException.class,
      HttpMessageNotWritableException.class,
      UserNorFoundException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //Genero el status de error en el servidor.
  public Map<String, Object> nullPointerException(Exception e) {

    Map<String, Object> error = new HashMap<>();

    error.put("date", new Date());
    error.put("error", "El usuario o role no existen.");
    error.put("Message", e.getMessage());
    error.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    return error;
  }


}
