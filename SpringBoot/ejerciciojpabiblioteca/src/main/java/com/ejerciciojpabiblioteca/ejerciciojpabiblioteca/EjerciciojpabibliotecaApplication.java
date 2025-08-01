package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca;

import com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.repositories.LibraryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjerciciojpabibliotecaApplication implements CommandLineRunner {

	private LibraryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciojpabibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



	}
}
