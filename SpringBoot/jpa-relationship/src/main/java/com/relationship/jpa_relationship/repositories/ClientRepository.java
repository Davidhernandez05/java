package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

  @Query("select c from Client c join fetch c.addresses")
  Optional<Client> findOne(Integer id);
}
