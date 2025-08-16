package com.ejercicio.to_dolist.to_do.list.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
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
  @JoinColumn(name = "user_id")
  private User user;

  public TaskList() {

  }

  public TaskList(String title, String task, Boolean completed) {
    this.setTitle(title);
    this.setTask(task);
    this.setCompleted(completed);
  }

  public Integer getId() {  return id;  }
  public String getTitle() {  return title; }
  public Boolean getCompleted() { return completed; }
  public String getTask() { return task;  }
  public User getUser() { return user;  }

  public void setTitle(String title) {  this.title = title; }
  public void setTask(String task) {  this.task = task; }
  public void setCompleted(Boolean completed) { this.completed = completed; }
  public void setUser(User user) {  this.user = user; }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    TaskList taskList = (TaskList) o;
    return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(task, taskList.task) && Objects.equals(completed, taskList.completed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, task, completed);
  }

  @Override
  public String toString() {
    return "{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", task='" + task + '\'' +
        ", completed=" + completed +
        '}';
  }
}
