package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.TaskList;

import java.util.List;
import java.util.Optional;

public interface TaskListService {

  List<TaskList> findAll();
  Optional<TaskList> findById(Integer id);

  TaskList save(TaskList task);
  Optional<TaskList> update(Integer id, TaskList task);
  Optional<TaskList> delete(Integer id);
}
