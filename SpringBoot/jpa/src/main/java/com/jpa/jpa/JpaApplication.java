package com.jpa.jpa;

import com.jpa.jpa.Entities.Person;
import com.jpa.jpa.dto.PersonDto;
import com.jpa.jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	// Tener en cuenta que este ejercicio es de JPA en terminal. -> Con BD MySql.

	@Override
	public void run(String... args) throws Exception {

		//create();
		//update();
		//delete2();
		//findOne();
		//list();
		//personalizedQueries2();
		//personalizedQueriesDistinct();
		//personalizedQueriesConcatUpperAndLowerCase();
		personalizedQueriesBetween();
	}

	@Transactional //El Transactional se utiliza cuando es un método que modifica la tabla de la BD.
	public void create() {

		// Crear un usuario con persistencia en la BD.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el nombre: ");
		String name = scanner.nextLine();

		System.out.print("Ingresa el apellido: ");
		String lastname = scanner.nextLine();

		System.out.print("Ingresa el lenguaje de programación: ");
		String languages = scanner.nextLine();
		scanner.close();

		Person person = new Person(null, name, lastname, languages);
		Person personNew = repository.save(person);

		System.out.println(personNew);

	}

	@Transactional
	public void update() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el ID que desea buscar: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(person -> {
			System.out.println(person);
			System.out.print("Ingrese el lenguaje de programación: ");
			String lenguaje = scanner.next();

			person.setProgramingLanguage(lenguaje);
			Person personUpdate = repository.save(person);
			System.out.println(personUpdate);

		}, () -> { System.out.println("El ID ingresado no existe en la BD!."); });
		scanner.close();
	}

	@Transactional
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el ID que deseas eliminar: ");
		Long id = scanner.nextLong();
		Optional<Person> deletePerson = repository.findById(id);
		System.out.println("Eliminaste al usuario: " + deletePerson.orElseThrow());

		repository.deleteById(id); // Esta es una forma de eliminar un elemento en la BD.
		repository.findAll().forEach(System.out::println);
		scanner.close();
		}

	@Transactional
	public void delete2() {
		// Esta es la segunda forma para realizar la eliminación de datos en la BD -> Este es el que mejor me parece a mí.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa el ID que deseas eliminar: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		//Esto es lo mismo que un IF Else solamente que en expresiones Lambda las cuales en mi opinion es mejor.
		optionalPerson.ifPresentOrElse(person -> {

			repository.delete(person);
			System.out.println("Eliminaste al usuario: " + person);

		}, () -> System.out.println("El ID que ingresaste no existe en la BD!."));

		repository.findAll().forEach(System.out::println);
		scanner.close();
	}
	@Transactional(readOnly = true)
	public void personalizedQueries() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el id: ");
		Long id = scanner.nextLong();
		scanner.close();

		System.out.println("==================== Mostramos el nombre por id ====================");
		String name = repository.getNameById(id);
		System.out.println("El nombre del usuario con id : " + id + " es: " + name);

		System.out.println("==================== Mostramos el nombre y el apellido por id ====================");
		String fullName = repository.getFullNameById(id);
		System.out.println("El nombre y apellido del usuario con id : " + id + " es: " + fullName);

		System.out.println("==================== Mostramos todos los registros en la BD ====================");
		List<Object[]> data = repository.obtenerPersonDataFull();
		data.forEach(personReg -> System.out.println("ID: " + personReg[0] + " Name: " + personReg[1] + " Lastname: " + personReg[2] + " Language Programing: " + personReg[3]));

		System.out.println("==================== Mostramos un registro de la BD por id ====================");
		Optional<Object> optionalRed = repository.obtenerPersonDataFullById(id);
		if (optionalRed.isPresent()){
			Object[] reg = (Object[]) optionalRed.orElseThrow();
			System.out.println("ID: " + reg[0] + " Name: " + reg[1] + " Lastname: " + reg[2] + " Language Programing: " + reg[3]);
		}

	}

	@Transactional(readOnly = true)
	public void personalizedQueries2() {

		System.out.println("==================== Consulta por Objeto persona y lenguaje de programación ====================");
		List<Object[]> personsRegs = repository.findMixPersonData();

		personsRegs.forEach(registro -> {
			System.out.println("Lenguaje de Programación: " + registro[1] + ", Person: " + registro[0]);
		});

		System.out.println("Consulta que puebla y devuelve un Objeto entity de una instancia personalizada:");
		List<Person> persons = repository.findAllPersonPersonalized();
		persons.forEach(System.out::println); //Solamente nos regresa llenos los campos: nombre y apellido

		System.out.println("Consulta que puebla y devuelve un Objeto DTO de una clase personalizada:");
		List<PersonDto> personDto = repository.findAllPersonDTO();
		personDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct(){
		System.out.println("Consulta que retorna todos los nombres:");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println("Consulta que omitiendo los nombres que se repiten:");
		names = repository.findAllNamesDistinct();
		names.forEach(System.out::println);

		System.out.println("Consulta que omitiendo los Lenguajes de programación que se repiten:");
		List<String> languagesDistinct = repository.findAllProgramingLanguagesDistinct();
		languagesDistinct.forEach(System.out::println);

		System.out.println("Consulta que cuenta los lenguajes de programación unicos:");
		Long totalLanguages = repository.findAllProgramingLanguagesDistinctCount();
		System.out.println("Total de lenguajes de programación encontrados: " + totalLanguages);

	}

	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase() {
		System.out.println("Consultar nombres (Mayúsculas) y apellidos (Minúsculas) de personas");
		List<String> fullName = repository.findAllFullNameConcat2();
		fullName.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el primer numero: ");
		Integer num1 = scanner.nextInt();
		System.out.print("Ingrese el segundo numero: ");
		Integer num2 = scanner.nextInt();

		System.out.println("Consulta con el método BETWEEN retorna del ID: " + num1 + "a l ID: " + num2 + ":");
		//List<Person> personas = repository.findAllBetweenId(num1, num2); // Esta dos consultas hacen lo mismo.
		List<Person> personas = repository.findByIdBetween(num1, num2);
		personas.forEach(System.out::println);

		System.out.print("Ingrese el primer carácter: ");
		String c1 = scanner.next();
		System.out.print("Ingrese el segundo carácter: ");
		String c2 = scanner.next();

		System.out.println("Consulta con el método BETWEEN retorna Los nombres que se encuentran entre la " + c1 + " y la " + c2 + ":"); // Tener en cuenta que excluye la E.
		//personas = repository.findAllBetweenNames(c1.toUpperCase(), c2.toUpperCase()); // Esta dos consultas hacen lo mismo.
		personas = repository.findByNameBetween(c1.toUpperCase(), c2.toUpperCase());
		personas.forEach(System.out::println);

		scanner.close();
	}

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true) //Cuando son consultas se utiliza él: readOnly = true -> Solo lectura de datos.
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
