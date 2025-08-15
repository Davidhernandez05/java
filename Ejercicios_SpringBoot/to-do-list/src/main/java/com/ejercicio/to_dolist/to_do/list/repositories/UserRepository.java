package com.ejercicio.to_dolist.to_do.list.repositories;

import com.ejercicio.to_dolist.to_do.list.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
