package com.relationship.jpa_relationship.repositories;

import com.relationship.jpa_relationship.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

  @Query("select s from Student s left join fetch s.courses where s.id = :id")
  Optional<Student> findOneWithCourses(@Param("id") Integer id);
}
