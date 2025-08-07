package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  private String lastname;

  //orphanRemoval = true -> Hace que se eliminen las direcciones huérfanas.
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Address> addresses;

  public Client() {
    addresses = new ArrayList<>();
  }

  public Client(String name, String lastname) {
    this(); // Esto llama al constructor vacío.
    this.setName(name);
    this.setLastname(lastname);
  }

  public Integer getId() {  return id;  }
  public String getName() { return name;  }
  public String getLastname() { return lastname;  }
  public List<Address> getAddresses() { return addresses; }

  public void setName(String name) {  this.name = name; }
  public void setLastname(String lastname) {  this.lastname = lastname; }
  public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", name:'" + name + '\'' +
        ", lastname:'" + lastname + '\'' +
        ", addresses:'" + addresses + '\'' +
        '}';
  }
}
