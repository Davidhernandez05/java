package com.difactura.difactura.models;

public class Item {

  private Product product;
  private Integer quantity;

  public Item () {
  }

  public Item(Product product, Integer quantity) {
    this.setProduct(product);
    this.setQuantity(quantity);
  }

  //getters:
  public Product getProduct() { return product; }
  public Integer getQuantity() {  return quantity;  }
  public Integer getTotal() { return quantity * product.getPrice(); }

  //Setters:
  public void setProduct(Product product) { this.product = product; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
