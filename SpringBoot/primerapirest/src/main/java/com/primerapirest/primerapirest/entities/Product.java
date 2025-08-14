package com.primerapirest.primerapirest.entities;

import com.primerapirest.primerapirest.validation.IsExistsDB;
import com.primerapirest.primerapirest.validation.IsRequired;
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

  // Los mensajes de error personalizados se pueden hacer desde aquí directamente o para que sea más limpio desde un archivo properties en recursos.
  //@NotEmpty(message = "no puede estar vacío por favor validar y volver a intentar.") // -> Porque es un string.
  @IsRequired //Creamos nuestra propia clase required. -> También recibe mensajes personalizados y desde properties.
  @Size(min = 2) // -> Esto es muy importante para asignar un mínimo y maximo de un password
  private String name;

  // Asi seria desde un archivo properties:
  @Min(50)
  @NotNull(message = "{NotNull.product.price}") // -> Esta funciona para todos los demás tipos de datos.
  private Integer price;

  @NotBlank(message = "{NotBlank.product.description}") // -> Es un poco más completa que NotEmpty, y también sirve para Strings,
  // Hace lo mismo que el NotEmpty, pero le añade que el campo no puede estar vacío.
  private String description;

  @IsExistsDB
  @IsRequired
  private String sku;

}
