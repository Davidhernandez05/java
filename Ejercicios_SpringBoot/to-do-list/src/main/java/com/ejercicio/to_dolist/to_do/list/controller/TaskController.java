package com.ejercicio.to_dolist.to_do.list.controller;

import com.ejercicio.to_dolist.to_do.list.entities.TaskList;
import com.ejercicio.to_dolist.to_do.list.services.TaskListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

  @Autowired
  private TaskListService service;

  @GetMapping()
  public List<TaskList> listTask() {
    return service.findAll();
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> createTask(@Valid @RequestBody TaskList taskList, @PathVariable Integer id) {
    return service.save(taskList, id);
  }

  @GetMapping("/{id}")
  public Optional<?> view(@PathVariable Integer id) {
    return service.findById(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
    return service.delete(id);
  }

}
