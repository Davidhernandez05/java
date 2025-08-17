package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.TaskList;
import com.ejercicio.to_dolist.to_do.list.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TaskListService {

  List<TaskList> findAll();
  ResponseEntity<?> findById(Integer id);

  ResponseEntity<User> save(TaskList task, Integer id);
  ResponseEntity<?> update(Integer id, TaskList task);
  ResponseEntity<?> delete(Integer id);
}
