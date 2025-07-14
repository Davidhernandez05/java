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
        System.out.println("Deseas separar (Si, No) el libro: ");
        var separar = sc.nextLine();

        if (separar.toLowerCase().trim().equals("si")) {
          sc = new Scanner(System.in);
          System.out.print("Ingresa el email del usuario que vas a buscar: ");
          var emailUser = sc.nextLine();

          for (Usuarios usuario : listaUsuarios) {
            if (usuario.getEmail().toLowerCase().trim().equals(emailUser)) {
              System.out.println("El libro se separo por lo cual ya no se encuentra disponible en el sistema.");
              libro.setDisponibilidad(false);
              listaBiblioteca.add(new Biblioteca(usuario.getName(), libro.getTitle(), libro.isDisponibilidad()));
            }
          }
          break;
        }
      }else {
        System.out.println("El libro ingresado no se encuentra disponible.");
      }
    }
  }


}
