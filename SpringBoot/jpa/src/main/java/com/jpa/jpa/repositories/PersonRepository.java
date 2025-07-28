package com.jpa.jpa.repositories;


import com.jpa.jpa.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

  List<Person> findByProgramingLanguage(String programingLanguage); // Nos permite buscar por un campo, tenemos que poner findBy y el nombre del campo donde se busca.

  @Query("select p from Person p where p.programingLanguage=?1 and name=?2")
  List<Person> buscarProgramingLanguage(String programingLanguage, String name);

  List<Person> findByNameAndProgramingLanguage(String name, String programingLanguage);
}
