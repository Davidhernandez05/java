package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca;

import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.entities.BasicLibrary;
import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.repositories.LibraryRepository;
import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services.Opciones;
import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services.SolicitarDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class EjerciciojpabibliotecaApplication implements CommandLineRunner {

	//Inyectamos el Repository:
	@Autowired
	private LibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciojpabibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {
			Integer opc = new Opciones().Select();
			if (opc == 1) {
				Create();
			} else if (opc == 2) {
				Delete();
			}else if (opc == 3) {
				System.out.println("3");
			}else if (opc == 4) {
				System.out.println("4");
			}else if (opc == 5) {
				Update();
			}else if (opc == 6) {
				System.out.println("Cerrando el aplicativo.");
				break;
			}else {
				System.out.println("Opción ingresada no valida inténtelo nuevamente.");
			}

		}



	}

	// Crear un nuevo libro.
	@Transactional
	public void Create() {
		//Solicitamos los datos
		Map<String, String> data = new SolicitarDatos().DataCreate();

		//Validamos que el MAP tenga las keys que necesitamos:
		if (!data.containsKey("Libro") || !data.containsKey("Autor") || !data.containsKey("Genero")) {
			throw new IllegalArgumentException("Dato solicitados no proporcionados.");
		}

		//Guardamos los valores del MAP en sus respectivas variables:
		String book = data.get("Libro");
		String autor = data.get("Autor");
		String genero = data.get("Genero");


		//Guardamos los valores en la BD:
		BasicLibrary library = new BasicLibrary(null, book, autor, genero);
		BasicLibrary bookNew = repository.save(library);
		System.out.println(bookNew);

	}

	//Eliminar un libro por ID.
	@Transactional
	public void Delete() {
		Integer id = new SolicitarDatos().solicitarId();

		//Buscamos por el ID en el repositorio.
		Optional<BasicLibrary> optionalBasicLibrary = repository.findById(id);

		// Si existe el ID lo elimina si no envía mensaje de que no se encontró.
		optionalBasicLibrary.ifPresentOrElse(book -> {
			repository.delete(book);
			System.out.println("Eliminaste el libro: \n" + book);
		}, () -> System.out.println("No se encontró el libro en la Base de Datos.") );

		// Imprimimos todos los elementos de la BD.
		System.out.println("Libros en la Base de Datos luego de la eliminación del ID: " + id);
		repository.findAll().forEach(System.out::println);
	}

	@Transactional
	public void Update() {

		// Buscamos el ID.
		Integer id = new SolicitarDatos().solicitarId();
		Optional<BasicLibrary> optionalBasicLibrary = repository.findById(id);
		optionalBasicLibrary.ifPresentOrElse(book -> {

			System.out.print("====================================================================================");
			System.out.println("|Se modificara el libro: \n" + book);
			System.out.print("====================================================================================");

			Map<String, String> newData = new SolicitarDatos().UpdateData();

			String newName = newData.get("newName");
			String newAutor = newData.get("newAutor");
			String newGender = newData.get("newGender");

			if (!newName.isBlank()) {
				book.setBookName(newName);
			}else {
				book.setBookName(book.getBookName());
			}
			if (!newAutor.isBlank()) {
				book.setAutorName(newAutor);
			}else {
				book.setAutorName(book.getAutorName());
			}
			if (!newGender.isBlank()) {
				book.setGender(newGender);
			}else {
				book.setGender(book.getGender());
			}

			BasicLibrary newBook = repository.save(book);

			System.out.print("====================================================================================");
			System.out.println("| Se actualizo correctamente el libro con el ID: " + id + "|");
			System.out.println(newBook);
			System.out.print("====================================================================================");

		}, () -> System.out.println("El ID no se encuentra en la Base de Datos."));


	}
}
