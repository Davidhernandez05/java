package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.DTO.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class RequestParamsController {

  @GetMapping("/foo")
  //localhost:8080/params/foo?mensaje=david.
  public ParamDto foo(@RequestParam(required = true, defaultValue = "Hola bienvenido.") String mensaje) {

    ParamDto param = new ParamDto();
    param.setMessage(mensaje);

    return param;
  }

  @GetMapping("/bar")
  //localhost:8080/params/bar?text=david&code=123
  public ParamDto bar(@RequestParam(required = true) String text, @RequestParam(required = true) Integer code) {
    ParamDto params = new ParamDto();
    params.setMessage(text);
    params.setCode(code);

    return params;

  }

  @GetMapping("/request")
  public ParamDto request(HttpServletRequest request) {
    //localhost:8080/params/request?code=12414&message=algun mensaje
    int code = 10;

    try {
      //Manejo de error en caso de que se envíe algo que no es un número.
      code = Integer.parseInt(request.getParameter("code"));
    }catch (NumberFormatException e) {

    }

    ParamDto params = new ParamDto();
    params.setCode(code);
    params.setMessage(request.getParameter("message"));
    return params;
  }



}
