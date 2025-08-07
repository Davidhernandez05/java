package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Address, Integer> {
}
