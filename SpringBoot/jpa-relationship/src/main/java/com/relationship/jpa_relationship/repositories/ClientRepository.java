package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
