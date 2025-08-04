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

		Integer opc = new Opciones().Select();

		System.out.println(opc);

	}

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

}
