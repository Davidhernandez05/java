package com.jpa.jpa.dto;

public class PersonDto {

  private String name;
  private String lastname;


  public PersonDto(String name, String lastname) {
    this.setName(name);
    this.setLastname(lastname);
  }


  public String getName() { return name;  }
  public String getLastname() { return lastname;  }


  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }

  @Override
  public String toString() {
    return "PersonDto [name= " + name + ", Lastname= " + lastname + "]";
  }
}
