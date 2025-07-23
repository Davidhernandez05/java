package com.difactura.difactura.models;

public class Product {

  private String name;
  private Integer price;

  //Constructors:
  public Product() {

  }

  public Product(String name, Integer price) {
    this.setName(name);
    this.setPrice(price );
  }

  //Getters:
  public String getName() { return name;  }
  public Integer getPrice() { return price; }

  //Setters:
  public void setName(String name) {  this.name = name; }
  public void setPrice(Integer price) { this.price = price; }
}
