package com.di_app.di_app.Models;


public class Product implements Cloneable {

  private long id;
  private String name;
  private long price;

  //Constructors:
  public Product() {
    //Constructor vacío.
  }

  public Product(long id, String name, long price) {
    setId(id);
    setName(name);
    setPrice(price);
  }

  // Getters:
  public String getName() { return name;  }
  public Long getId() { return id;  }
  public Long getPrice() { return price; }

  //Setters:
  public void setId(Long id) {  this.id = id; }
  public void setName(String name) {  this.name = name; }
  public void setPrice(Long price) { this.price = price; }

  @Override
  public Object clone() {
    try {
      return super.clone();
    }catch (CloneNotSupportedException e) {
      return new Product(id, name, price);
    }
  }
}
