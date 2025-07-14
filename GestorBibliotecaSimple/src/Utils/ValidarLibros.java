package Utils;

import Clases.Libros;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidarLibros {

  static ArrayList<Libros> listaLibros = new ArrayList<Libros>();
  public static void AgregarLibro() {


    var sc = new Scanner(System.in);
    System.out.print("Ingresa el titulo del libro: ");
    var titulo = sc.nextLine();

    sc = new Scanner(System.in);
    System.out.print("Ingresa el nombre del autor: ");
    var autor = sc.nextLine();

    sc = new Scanner(System.in);
    System.out.print("Ingresa el año de publicación del libro: ");
    var year = sc.nextInt();

    sc = new Scanner(System.in);
    System.out.print("Ingresa true si el libro esta disponible o false si no lo esta: ");
    var disponibilidad = sc.nextBoolean();

    listaLibros.add(new Libros(titulo, autor, year, disponibilidad));
    System.out.println(String.format("Se agrego el libro: %s del autor: %s que se publico en el año: %d", titulo, autor, year));
  }

  public static void ListarLibros() {
    System.out.println("Lista de libros: ");
    for (Libros libro : listaLibros) {
      System.out.println(String.format("ID: %d Libro: %s, Autor: %s, Disponibilidad: %b", libro.getId(), libro.getTitle(), libro.getAuthor(), libro.isDisponibilidad()));
    }
  }

  public static boolean buscarLibro(String nombre) {

    for (Libros libro : listaLibros) {
      if (libro.getTitle().toLowerCase().trim().equals(nombre.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}
