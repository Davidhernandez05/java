package com.jpa.jpa;

import com.jpa.jpa.Entities.Person;
import com.jpa.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		create();
		//findOne();
		//list();
	}

	public void findOne(){
		//Person person = repository.findById(2L).orElseThrow();
		//Person person = null;
		//Optional<Person> optionalPerson = repository.findById(2L);

		//if (optionalPerson.isPresent()) {
		//	person = optionalPerson.get();
		//	System.out.println(person);
		//}else {
		//	System.out.println("No se encontró al usuario con el id indicado.");
		//}

		// Otra forma pero mejor de hacer lo de arriba.
		repository.findOne(2L).ifPresent(System.out::println);
		repository.findName("David").ifPresent(System.out::println);
		repository.findOneLikeName("Mig").ifPresent(System.out::println);
		repository.findByNameContaining("res").ifPresent(System.out::println);
		repository.findByName("Ricardo").ifPresent(System.out::println);


	}

	public void create() {

		// Crear un usuario con persistencia en la BD.
		Person person = new Person(null, "Lalo", "Thor", "PHP");
		Person personNew = repository.save(person);

		System.out.println(personNew);

	}

	public void list() {

		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarProgramingLanguage("Python", "Miguel");
		List<Person> persons = (List<Person>) repository.findByNameAndProgramingLanguage("Alejandra", "CSS");


		persons.forEach(System.out::println);


		List<Object[]> personValues = repository.obtenerPersonData();
		personValues.forEach(person -> {
			System.out.println(person[0] + " Es experto en: " + person[1]);
		});
	}
}
