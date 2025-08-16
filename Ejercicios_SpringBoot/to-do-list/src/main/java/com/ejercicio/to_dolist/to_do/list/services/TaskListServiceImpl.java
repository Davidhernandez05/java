package com.ejercicio.to_dolist.to_do.list.services;

import com.ejercicio.to_dolist.to_do.list.entities.TaskList;
import com.ejercicio.to_dolist.to_do.list.entities.User;
import com.ejercicio.to_dolist.to_do.list.repositories.TaskListRepository;
import com.ejercicio.to_dolist.to_do.list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskListServiceImpl implements TaskListService {

  @Autowired
  private TaskListRepository repository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TaskListRepository taskListRepository;

  @Override
  @Transactional(readOnly = true)
  public List<TaskList> findAll() {
    return (List<TaskList>) repository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<TaskList> findById(Integer id) {
    return repository.findById(id);
  }

  @Transactional
  @Override
  public ResponseEntity<User> save(TaskList task, Integer id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {

      User user = optionalUser.get();
      user.getTaskList().add(task); // Agregamos la tarea a nuestra lista ya creada.

      task.setUser(user);

      User userBD = userRepository.save(user); // Guardamos el usuario con su nueva tarea.

      return ResponseEntity.ok().body(userBD);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).
        body((User) Map.of("mensaje:", "Usuario con id: " + id + "No encontrado."));
  }

  @Override
  @Transactional
  public Optional<TaskList> update(Integer id, TaskList task) {
    return Optional.empty();
  }

  @Override
  @Transactional
  public ResponseEntity<?> delete(Integer id) {
    Optional<TaskList> optionalTaskList = taskListRepository.findById(id);

    if (optionalTaskList.isPresent()) {
      TaskList task = optionalTaskList.get();
      repository.delete(task);
      return ResponseEntity.ok().body(Map.of("Mensaje: ", "Se elimino correctamente la tarea"));

    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensaje: ", "No se encontró ninguna tarea con el ID: " + id));
  }
}
