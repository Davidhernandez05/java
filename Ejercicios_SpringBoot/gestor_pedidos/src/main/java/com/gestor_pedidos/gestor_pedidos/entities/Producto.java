package com.gestor_pedidos.gestor_pedidos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "Nombre de producto no valido.")
  @Column(unique = true)
  private String name;

  @Min(value = 1, message = "Precio no valido.")
  private Double price;

  @Min(value = 0, message = "Stock no valido.")
  private Integer stock;
}
