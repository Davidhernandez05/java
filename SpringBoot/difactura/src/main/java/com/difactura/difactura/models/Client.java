package com.difactura.difactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {

  @Value("${client.name}")
  private String name;

  @Value("${client.lastname}")
  private String lastname;

  //constructors:
  public Client (){
  }

  public Client(String name, String lastname) {
    this.setName(name);
    this.setLastname(lastname);
  }

  //Getters:
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }

  //Setters:
  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
}
