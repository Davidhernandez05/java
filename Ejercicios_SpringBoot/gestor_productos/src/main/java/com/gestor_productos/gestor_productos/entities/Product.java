package com.gestor_productos.gestor_productos.entities;

import com.gestor_productos.gestor_productos.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  //@IsRequired
  //@Size(min = 1)
  @NotEmpty(message = "Nombre del producto no valido.")
  @Size(min = 2, message = "Nombre no valido.")
  private String name;

  @Min(value = 1, message = "Precio no valido.")
  private Double price;

  @Min(value = 1, message = "El producto debe ser mínimo 1")
  private Integer stock;
  private Boolean disponibilidad;

  @ManyToOne()
  @Getter(AccessLevel.NONE)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JoinColumn(name = "category_id")
  private Category category;

}
