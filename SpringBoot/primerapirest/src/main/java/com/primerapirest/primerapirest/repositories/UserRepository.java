package com.primerapirest.primerapirest.repositories;

import com.primerapirest.primerapirest.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
