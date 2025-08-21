package com.gestor_productos.gestor_productos.dto;

import com.gestor_productos.gestor_productos.entities.Product;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryDto {

  private Integer id;
  private String name;
  private Set<Product> product;
}
