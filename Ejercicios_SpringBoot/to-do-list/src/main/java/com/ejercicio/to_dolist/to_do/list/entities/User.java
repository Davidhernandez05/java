package com.ejercicio.to_dolist.to_do.list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "El nombre no puede estar vacío.")
  private String name;

  @NotBlank(message = "El apellido no puede estar vacío.")
  private String lastname;

  @NotBlank(message = "El email no puede estar vacío.")
  private String email;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<TaskList> taskList;
}
