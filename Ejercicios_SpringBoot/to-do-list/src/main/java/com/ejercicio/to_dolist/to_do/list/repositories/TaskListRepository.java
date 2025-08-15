package com.ejercicio.to_dolist.to_do.list.repositories;

import com.ejercicio.to_dolist.to_do.list.entities.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {
}
