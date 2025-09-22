package com.gestor_pedidos.gestor_pedidos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name = "Detalles")
public class DetallesPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "producto_id")
  private Producto productos;

  @Min(value = 1, message = "Cantidad no valida.")
  private Integer cantidad;
  private Double subTotal;
}
