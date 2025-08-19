package com.gestor_productos.gestor_productos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  private String name;
  private String description;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
  private Set<Product> product;
}
