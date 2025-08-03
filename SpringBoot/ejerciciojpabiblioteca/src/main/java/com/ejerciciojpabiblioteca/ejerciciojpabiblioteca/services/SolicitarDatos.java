package com.ejerciciojpabiblioteca.ejerciciojpabiblioteca.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolicitarDatos {

  public Map<String, String> DataCreate() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa el nombre del libro: ");
    String book = scanner.nextLine();

    System.out.print("Ingresa el nombre del autor: ");
    String autor = scanner.nextLine();

    System.out.print("Ingresa el genero del libro: ");
    String generoLibro = scanner.nextLine();

    scanner.close();

    Map<String, String> data = new HashMap<>();
    data.put("Libro" , book);
    data.put("Autor" , autor);
    data.put("GeneroLibro" , generoLibro);

    return data;
  }


}
