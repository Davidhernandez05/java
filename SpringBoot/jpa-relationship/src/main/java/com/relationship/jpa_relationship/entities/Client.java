package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String lastname;

  public Client() {

  }

  public Client(String name, String lastname) {
    this.setName(name);
    this.setLastname(lastname);
  }

  public Integer getId() {  return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }

  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", name:'" + name + '\'' +
        ", lastname:'" + lastname + '\'' +
        '}';
  }
}
