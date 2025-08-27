package com.primerapirest.primerapirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.primerapirest.primerapirest.validation.ExistsByUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
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
  @ExistsByUsername
  private String username;

  @Size(min = 2, message = "La contraseña debe tener un mínimo de 8 caracteres y un maximo de 10.")
  @NotEmpty(message = "Contraseña no valida intenta nuevamente.")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Hace que solamente se muestre al momento de ingresar los datos.
  private String password;

  @ManyToMany
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "user_id"), //Mapeamos las llaves foramens que tenemos en nuestra tabla ya creada.
      inverseJoinColumns = @JoinColumn(name = "role_id"),
      uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})} //Indicamos cuales son las columnas únicas en este caso son ambas.
  )
  @EqualsAndHashCode.Exclude
  @JsonIgnoreProperties({"users", "handler", "hibernateLazyInitializer"}) // Esto es para que no se cree el error del ciclo.
  //"handler", "hibernateLazyInitializer" -> Son del proxy que no queremos inicializar.
  private List<Role> roles;

  private Boolean enabled;

  @PrePersist
  public void prePersist() {
    enabled = true;
  }

  @Transient //-> Le dice a jpa que este campo no es de la tabla solamente de la clase.
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Hace que solamente se muestre al momento de ingresar los datos.
  private Boolean admin;

  public User() {
    this.roles = new ArrayList<>();
  }

}
