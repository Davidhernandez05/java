package com.gestormensajesapp.gestormensajesapp.Models;

public class User{

  private Integer id;
  private String name;
  private String lastname;
  private int age;

  //Constructors:
  public User () {
    //Constructor Vacío.
  }

  public User (Integer id, String name, String lastname, int age) {
    setId(id);
    setName(name);
    setLastname(lastname);
    setAge(age);
  }

  //Getters:
  public Integer getId() {  return id;  }
  public String getName() { return name; }
  public String getLastname() { return lastname; }
  public int getAge() { return age;  }

  //Setters:
  public void setId(Integer id) {this.id = id;}
  public void setName(String name) {  this.name = name;}
  public void setLastname(String lastname) {  this.lastname = lastname;}
  public void setAge(int age) { this.age = age; }
}
