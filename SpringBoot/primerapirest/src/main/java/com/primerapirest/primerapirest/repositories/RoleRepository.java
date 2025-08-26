package com.primerapirest.primerapirest.repositories;

import com.primerapirest.primerapirest.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {

  Optional<Role> findByName(String name);
}
