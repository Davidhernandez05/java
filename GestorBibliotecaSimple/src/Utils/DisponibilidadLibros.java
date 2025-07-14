package Utils;

import Clases.Biblioteca;
import Clases.Libros;
import Clases.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class DisponibilidadLibros {
  static ArrayList<Biblioteca> listaBiblioteca = new ArrayList<>();

  public static void pedirLibro(String name) {
    var listaLibros = ValidarLibros.listaLibros;
    var listaUsuarios = ValidarUsuarios.listaUsuarios;

    for (Libros libro : listaLibros) {
      if (libro.getTitle().toLowerCase().trim().equals(name.toLowerCase()) && libro.isDisponibilidad()) {
        var sc = new Scanner(System.in);
        System.out.print("Deseas separar (Si, No) el libro: ");
        var separar = sc.nextLine();

        if (separar.toLowerCase().trim().equals("si")) {
          sc = new Scanner(System.in);
          System.out.print("Ingresa el email del usuario que vas a buscar: ");
          var emailUser = sc.nextLine();

          for (Usuarios usuario : listaUsuarios) {
            if (usuario.getEmail().toLowerCase().trim().equals(emailUser.toLowerCase().trim())) {
              System.out.println("El libro se separo por lo cual ya no se encuentra disponible en el sistema.");
              libro.setDisponibilidad(false);
              listaBiblioteca.add(new Biblioteca(usuario.getEmail(), libro.getTitle(), libro.isDisponibilidad()));
              System.out.println(String.format("El usuario: %s, Tiene el libro: %s", usuario.getName(), libro.getTitle()));
              break;
            }
          }
          break;
        }
      }
    }
  }

  public static boolean returnBook() {
    var listaLibros = ValidarLibros.listaLibros;
    var listaUsuarios = ValidarUsuarios.listaUsuarios;

    var sc = new Scanner(System.in);
    System.out.print("Deseas regresar un libro(Si, No): ");
    var regresar = sc.nextLine();

    if (regresar.toLowerCase().trim().equals("si")) {
      sc = new Scanner(System.in);
      System.out.print("Ingresa tu Email: ");
      var name = sc.nextLine();

      sc = new Scanner(System.in);
      System.out.print("Ingresa el nombre del libro que quieres regresar: ");
      var tittleBook = sc.nextLine();

      for (Biblioteca prestamos : listaBiblioteca) {
        if (prestamos.getUserSeparation().toLowerCase().trim().equals(name.toLowerCase().trim()) &&
            prestamos.getTittleBook().toLowerCase().trim().equals(tittleBook.toLowerCase().trim())) {

          if (!prestamos.isDisponibilidad()) {
            listaBiblioteca.remove(prestamos.getId());
            for (Libros libro : listaLibros) {
              if (libro.getTitle().toLowerCase().equals(tittleBook.toLowerCase().trim())) {
                libro.setDisponibilidad(true);
                return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  public static void returnBookValidation() {
    var regreso = returnBook();

    if (regreso) {
      System.out.println("El libro se regreso correctamente. \nLibro disponible en el sistema.");
    }else {
      System.out.println("El libro no se regreso correctamente intentalo nuevamente.");
    }
  }


  public static void librosDisponibles() {
    var listaLibros = ValidarLibros.listaLibros;

    System.out.println("Libros disponibles en este momento:");
    for (Libros libro : listaLibros) {
      if (libro.isDisponibilidad()) {
        System.out.println(libro.getTitle());
      }
    }
  }

  public static void librosNoDisponibles() {

    System.out.println("Libros prestados: ");
    for (Biblioteca libro : listaBiblioteca) {
      System.out.println(String.format("El libro: %s, lo tiene: %s, disponibilidad en este momento: %b", libro.getTittleBook(), libro.getUserSeparation(), libro.isDisponibilidad()));
    }
  }
}
