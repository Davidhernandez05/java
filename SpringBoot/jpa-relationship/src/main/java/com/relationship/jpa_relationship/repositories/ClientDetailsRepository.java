package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.ClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Integer> {
}
