package com.gestor_productos.gestor_productos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  private String name;

  @Min(1)
  private Double price;

  @Min(1)
  private Integer stock;
  private Boolean disponibilidad;

  @OneToOne()
  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JoinColumn(name = "category_id")
  private Category category;


  public Product (String name, Double price, Integer stock, Boolean disponibilidad) {
    this.setName(name);
    this.setStock(stock);
    this.setPrice(price);
    this.setDisponibilidad(disponibilidad);
  }
}
