package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;

  private String country;
  private String street;
  protected Integer number;

  public Address() {

  }

  public Address(String country, String street, Integer number) {
    this.setCountry(country);
    this.setStreet(street);
    this.setNumber(number);
  }

  public Integer getId() {  return id;  }
  public String getCountry() {  return country; }
  public String getStreet() { return street;  }
  public Integer getNumber() {  return number;  }

  public void setCountry(String country) {  this.country = country; }
  public void setStreet(String street) {  this.street = street; }
  public void setNumber(Integer number) { this.number = number; }


  @Override
  public String toString() {
    return "{" +
        "id:" + id +
        ", country:'" + country + '\'' +
        ", street:'" + street + '\'' +
        ", number:" + number +
        '}';
  }


  // Nos permite eliminar un elemento de la lista mediante un criterio de búsqueda o comparación por el ID y no por referencia.
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(id, address.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
