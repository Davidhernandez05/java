package com.curso.webapp.webapp.models;

public class User {

  private String name;
  private String lastname;

  //Constructor:
  public User(String name, String lastname) {
    this.setName(name);
    this.setLastname(lastname);
  }

  //Getters:
  public String getName() { return name;   }
  public String getLastname() { return lastname;  }

  //Setters:
  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
}
