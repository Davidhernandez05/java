package com.primerapirest.primerapirest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty // -> Por que es un string.
  @Size(min = 2) // -> Esto es muy importante para asignar un mínimo y maximo de un password
  private String name;

  @Min(50)
  @NotNull // -> Esta funciona para todos los demás tipos de datos.
  private Integer price;

  @NotBlank // -> Es un poco más completa que NotEmpty, y también sirve para Strings,
  // Hace lo mismo que el NotEmpty, pero le añade que el campo no puede estar vacío.
  private String description;

}
