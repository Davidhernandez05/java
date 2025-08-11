package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
