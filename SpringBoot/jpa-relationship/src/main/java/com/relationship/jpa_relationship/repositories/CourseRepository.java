package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CourseRepository extends CrudRepository<Course, Integer> {

  @Query("select c from Course c left join fetch c.students where c.id = :id")
  Optional<Course> findOneWhitStudents(@Param("id") Integer id);


}
