package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opciones {

  public Integer Select() {

    Scanner scanner = new Scanner(System.in);
    Menu();
    try {
      System.out.print("Ingresa una opción: ");
      return scanner.nextInt();

    }catch (InputMismatchException e) {
      System.out.println("Opción no valida.");
      return 0;
    }
  }

  private void Menu() {
    System.out.println("1. Crear un nuevo libro en la base de datos.");
    System.out.println("2. Eliminar un libro de la base de datos.");
    System.out.println("3. Mostrar todos los libros registrados en la base de datos.");
    System.out.println("4. Buscar un libro por ID.");
    System.out.println("5. Salir del sistema.");
  }

}
