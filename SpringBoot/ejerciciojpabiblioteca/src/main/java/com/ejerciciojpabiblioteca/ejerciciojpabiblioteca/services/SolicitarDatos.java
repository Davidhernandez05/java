package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolicitarDatos {

  public Map<String, String> DataCreate() {
    Scanner scanner = new Scanner(System.in);
    Map<String, String> data = new HashMap<>();

    try {
      System.out.print("Ingresa el nombre del libro: ");
      String book = scanner.nextLine();
      if (book.isBlank()) {
        throw new IllegalArgumentException("El libro no puede estar vacío.");
      }

      System.out.print("Ingresa el nombre del autor del libro: ");
      String autor = scanner.nextLine();
      if (autor.isBlank()) {
        throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
      }

      System.out.print("Ingresa el genero del libro: ");
      String genero = scanner.nextLine();

      data.put("Libro", book.trim());
      data.put("Autor", autor.trim());
      data.put("Genero", genero.trim());

      return data;
    }finally {
      
    }

  }


}
