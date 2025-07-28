package com.jpa.jpa;

import com.jpa.jpa.Entities.Person;
import com.jpa.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.buscarProgramingLanguage("Python", "Miguel");
		List<Person> persons = (List<Person>) repository.findByNameAndProgramingLanguage("Alejandra", "CSS");

		persons.forEach(System.out::println);
	}
}
