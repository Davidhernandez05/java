package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.DTO.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable(required = true) String message) {
    //localhost:8080/api/var/baz/David
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Integer id) {
    //localhost:8080/api/var/mix/teclado/12
    Map<String, Object> json = new HashMap<>();
    json.put("producto", product);
    json.put("id", id);

    return json;
  }
}
