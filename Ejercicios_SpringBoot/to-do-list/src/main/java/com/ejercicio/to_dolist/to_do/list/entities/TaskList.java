package com.ejercicio.to_dolist.to_do.list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

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

}
