package com.gestor_pedidos.gestor_pedidos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Size(min = 2, message = "El nombre mínimo debe tener 2 caracteres.")
  @NotEmpty(message = "Tienes que ingresar un nombre.")
  private String name;

  @Email(message = "Email no valido.")
  @Column(unique = true)
  private String email;

}
