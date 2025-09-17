package com.gestor_pedidos.gestor_pedidos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Cliente cliente;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY) // -> Ignora en entrada pero muestra en salida
  private Double total;
}
