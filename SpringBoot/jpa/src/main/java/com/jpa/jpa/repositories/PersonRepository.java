package com.jpa.jpa.repositories;


import com.jpa.jpa.Entities.Person;
import com.jpa.jpa.dto.PersonDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

  @Query("select p.name from Person p where p.id=?1")
  String getNameById(Long id);

  @Query("select concat(p.name, ' ', p.lastname) as fullName from Person p where p.id=?1")
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

  @Query("select new com.jpa.jpa.dto.PersonDto(p.name, p.lastname) from Person p") //Llamamos al constructor nuevo
  List<PersonDto> findAllPersonDTO();

  @Query("select p.name from Person p")
  List<String> findAllNames();

  @Query("select DISTINCT(p.name) from Person p")
  List<String> findAllNamesDistinct();

  @Query("select distinct(p.programingLanguage) from Person p")
  List<String> findAllProgramingLanguagesDistinct();

  @Query("SELECT COUNT(distinct(p.programingLanguage)) FROM Person p")
  Long findAllProgramingLanguagesDistinctCount();


  @Query("select concat(p.name, ' ', p.lastname) from Person p")
  List<String> findAllFullNameConcat();

  @Query("select UPPER(p.name) || ' ' || LOWER(p.lastname) from Person p") // || -> también nos permite concatenar datos.
  List<String> findAllFullNameConcat2();


  @Query("SELECT p FROM Person p WHERE p.id BETWEEN ?1 and ?2 ORDER BY p.name ASC")
  List<Person> findAllBetweenId(Integer num1, Integer num2);
  List<Person> findByIdBetweenOrderByIdAsc(Integer id1, Integer id2); // Esta consulta hace lo mismo que la de arriba pero con query name method.

  @Query("SELECT p FROM Person p WHERE p.name BETWEEN ?1 AND ?2 ORDER BY p.name DESC")
  List<Person> findAllBetweenNames(String c1, String c2);
  List<Person> findByNameBetweenOrderByNameDescLastnameAsc(String c1, String c2); // Esta consulta hace lo mismo que la de arriba pero con query name method.

  @Query("SELECT p FROM Person p ORDER BY p.name DESC")
  List<Person> getAllOrdered();
  List<Person> findAllByOrderByNameDescLastnameAsc(); //Esta consulta hace lo mismo que la de arriba



  @Query("SELECT COUNT(p.name) FROM Person p")
  Long totalPerson();

  @Query("SELECT MIN(p.id) FROM Person p")
  Long minId();

  @Query("SELECT MAX(p.id) FROM Person p")
  Long maxId();

}
