package com.jpa.jpa.repositories;


import com.jpa.jpa.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

  @Query("select p.name from Person p where p.id=?1")
  String getNameById(Long id);

  @Query("select concat(p.name, ' ', p.lastname) from Person p where p.id=?1")
  String getFullNameById(Long id);

  @Query("select p from Person p where p.id=?1")
  Optional<Person> findOne(Long id);

  @Query("select p from Person p where p.name=?1")
  Optional<Person> findName(String name);

  @Query("select p from Person p where p.name like %?1%")
  Optional<Person> findOneLikeName(String name);

  List<Person> findByProgramingLanguage(String programingLanguage); // Nos permite buscar por un campo, tenemos que poner findBy y el nombre del campo donde se busca.

  @Query("select p from Person p where p.programingLanguage=?1 and name=?2")
  List<Person> buscarProgramingLanguage(String programingLanguage, String name);

  List<Person> findByNameAndProgramingLanguage(String name, String programingLanguage);

  @Query("select p.name, p.programingLanguage from Person p") //También se puede utilizar el where con parámetros para filtrar en caso de requerirlo.
  List<Object[]> obtenerPersonData(); // También se puede realizar la sobrecarga de métodos en caso de requerirlo.

  @Query("select p.name, p.programingLanguage from Person p where p.name=?1")
  List<Object[]> obtenerPersonData(String name);

  Optional<Person> findByName(String name);
  Optional<Person> findByNameContaining(String name);

  @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p")
  List<Object[]> obtenerPersonDataFull();

  @Query("select p.id, p.name, p.lastname, p.programingLanguage from Person p where p.id=?1")
  Optional<Object> obtenerPersonDataFullById(Long id);



  @Query("select p, p.programingLanguage from Person p")
  List<Object[]> findMixPersonData();

  @Query("select new Person(p.name, p.lastname) from Person p") //Llamamos al constructor nuevo
  List<Person> findAllPersonPersonalized();
}
