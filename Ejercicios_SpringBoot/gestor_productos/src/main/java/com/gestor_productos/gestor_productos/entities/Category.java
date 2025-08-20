package com.gestor_productos.gestor_productos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Data
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull(message = "El nombre de la categoria no puede ser nulo.")
  private String name;
  private String description;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
  private Set<Product> product;

}
