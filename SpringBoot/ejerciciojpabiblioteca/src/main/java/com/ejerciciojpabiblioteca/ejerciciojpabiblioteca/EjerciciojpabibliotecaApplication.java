package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca;

import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.entities.BasicLibrary;
import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.repositories.LibraryRepository;
import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services.SolicitarDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@SpringBootApplication
public class EjerciciojpabibliotecaApplication implements CommandLineRunner {

	private LibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciojpabibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Create();

	}

	@Transactional
	public void Create() {
		Map<String, String> data = new SolicitarDatos().DataCreate();

		String book = data.get("Libro");
		String autor = data.get("Autor");
		String generoLibro = data.get("GeneroLibro");

		BasicLibrary library = new BasicLibrary(null, autor, book, generoLibro);
		BasicLibrary bookNew = repository.save(library);

		System.out.println(bookNew);

	}

}
