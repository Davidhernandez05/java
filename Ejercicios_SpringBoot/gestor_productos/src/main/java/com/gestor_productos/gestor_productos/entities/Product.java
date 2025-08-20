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

  @NotNull(message = "el nombre no puede ser null")
  private String name;

  @Min(value = 1, message = "precio no valido.")
  private Double price;

  @Min(value = 1, message = "El producto debe ser mínimo 1")
  private Integer stock;
  private Boolean disponibilidad;

  @OneToOne()
  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JoinColumn(name = "category_id")
  private Category category;

}
