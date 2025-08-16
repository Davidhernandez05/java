package com.ejercicio.to_dolist.to_do.list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@Table(name = "task_list")
public class TaskList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Por favor ingresa un titulo a la tarea.")
  private String title;
  private String task;

  @NotNull(message = "Por favor ingresa si la tarea esta completada o no.")
  private Boolean completed;

  @ManyToOne
  @Getter(AccessLevel.NONE) // Esto hace que no cree el getter en este campo.
  @EqualsAndHashCode.Exclude // Hace que el HashCode no tenga este valor
  @ToString.Exclude //Hace que el toString no tenga este valor
  @JoinColumn(name = "user_id")
  private User user;

}
