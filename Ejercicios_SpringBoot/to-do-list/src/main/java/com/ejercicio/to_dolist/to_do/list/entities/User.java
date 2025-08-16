package com.ejercicio.to_dolist.to_do.list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
  private Set<TaskList> taskList;

  public User () {
    taskList = new HashSet<>();
  }

  public User(String name, String lastname, String email) {
    this();
    this.setName(name);
    this.setLastname(lastname);
    this.setEmail(email);
  }
}
