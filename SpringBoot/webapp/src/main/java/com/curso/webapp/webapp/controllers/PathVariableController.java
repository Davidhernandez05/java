package com.curso.webapp.webapp.controllers;

import com.curso.webapp.webapp.models.DTO.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  // Anotación Value para inyectar valores de properties.
  @Value("${config.name}")
  private String name;

  @Value("${config.message}")
  private String message;

  @Value("${config.listOfValues}")
  private String[] listOfValues;

  @Value("#{${config.valuesMap}}")
  private Map<String, Object> valuesMap;

  @Value("#{${config.valuesMap}.product}")
  private String product;

  @Value("#{${config.valuesMap}.price}")
  private Integer price;

  //Inyectar dependencias.
  @Autowired
  private Environment environment;

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

  @GetMapping("/values")
  public Map<String, Object> values(@Value("${config.code}") Integer code) { // También se pueden inyectar de esta forma directamente al método.
    Map<String, Object> json = new HashMap<>();
    json.put("Name", name);
    json.put("Code", environment.getProperty("config.code", Integer.class));
    json.put("Message", environment.getProperty("config.message")); //Siempre regresa un String.
    json.put("List", listOfValues);
    json.put("Productos", valuesMap);
    json.put("producto", product);
    json.put("precio", price);

    return json;
  }
}
