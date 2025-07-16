package com.apiproductos.apiproductos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Entity
@Table(name = "productos")
@Data
public class Producto {
  @id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nombreProducto;
  private double precioProducto;
  private int cantidad;
}
