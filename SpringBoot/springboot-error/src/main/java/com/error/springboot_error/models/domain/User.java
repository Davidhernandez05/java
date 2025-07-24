package com.error.springboot_error.models.domain;

public class User {

  private Long id;
  private String name;
  private String lastname;

  private Role role;

  //Constructors:

  public User () {

  }

  public User (Long id, String name, String lastname) {
    this.setId(id);
    this.setName(name);
    this.setLastname(lastname);
  }

  //Getters
  public Long getId() { return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }
  public Role getRole() { return role;  }

  //Setters:
  public void setId(Long id) {  this.id = id; }
  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
  public void setRole(Role role) {  this.role = role; }
}

