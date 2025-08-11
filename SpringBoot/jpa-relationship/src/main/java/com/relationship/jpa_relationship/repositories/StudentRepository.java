package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
