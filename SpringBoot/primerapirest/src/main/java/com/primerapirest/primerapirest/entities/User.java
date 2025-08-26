package com.primerapirest.primerapirest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true) // Para que sean valores unicos.
  @Size(
      min = 4,
      message = "El mínimo de caracteres para el username es de 4 por favor validar."
  )
  @NotEmpty(message = "Username no valido intentalo nuevamente.")
  private String username;

  @Size(min = 8,max = 10, message = "La contraseña debe tener un mínimo de 8 caracteres y un maximo de 10.")
  @NotEmpty(message = "Contraseña no valida intenta nuevamente.")
  private String password;

  @ManyToMany
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id"), //Mapeamos las llaves foramens que tenemos en nuestra tabla ya creada.
      inverseJoinColumns = @JoinColumn(name = "role_id"),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})} //Indicamos cuales son las columnas únicas en este caso son ambas.
  )
  private List<Role> roles;

  @Transient //-> Le dice a jpa que este campo no es de la tabla solamente de la clase.
  private Boolean admin;
}
