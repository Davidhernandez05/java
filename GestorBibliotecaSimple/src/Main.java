import Clases.Libros;
import Utils.DisponibilidadLibros;
import Utils.ValidarLibros;
import Utils.ValidarUsuarios;

import java.util.ArrayList;
import java.util.Scanner;

import static Utils.Menu.menu;


public class Main {

  public static void main(String[] args) {

    while (true) {
      int opc = menu();

      if (opc == 1) {
        ValidarLibros.AgregarLibro();
      } else if (opc == 2) {
        ValidarLibros.ListarLibros();
      } else if (opc == 3) {
        ValidarUsuarios.AgregarUsuario();
      } else if (opc == 4) {
        ValidarUsuarios.listarUsuarios();
      } else if (opc == 5) {

        var sc = new Scanner(System.in);
        System.out.print("Ingresa el nombre del libro que quieres buscar: ");
        String nombre = sc.nextLine();

        var existe = ValidarLibros.buscarLibro(nombre);
        if (existe) {
          System.out.println("El libro si se encuentra en nuestra Base de Datos.");
        }else {
          System.out.println("El libro no se encuentra en nuestra Base de Datos.");
        }
      } else if (opc == 6) {
        var sc = new Scanner(System.in);
        System.out.print("Ingresa el nombre del libro que quieres Solicitar: ");
        String name = sc.nextLine();
        DisponibilidadLibros.pedirLibro(name);

      } else if (opc == 7) {
        var regreso = DisponibilidadLibros.regresarLibro();

        if (regreso) {
          System.out.println("El libro se regreso correctamente. \nLibro disponible en el sistema.");
        }else {
          System.out.println("El libro no se regreso correctamente intentalo nuevamente.");
        }
      }
      if (opc == 8) {
        break;
      } else {
        System.out.println("Opción no valida intenta nuevamente.");
      }

    }
  }
}