package com.relationship.jpa_relationship.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String description;
  private Integer total;

  public Invoice() {
  }

  public Invoice(String description, Integer total){
    this.setDescription(description);
    this.setTotal(total);
  }


  public Integer getId() {  return id;  }
  public String getDescription() {  return description; }
  public Integer getTotal() { return total; }

  public void setDescription(String description) {  this.description = description; }
  public void setTotal(Integer total) { this.total = total; }


}
