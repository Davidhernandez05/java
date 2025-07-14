import Clases.Libros;
import Utils.DisponibilidadLibros;
import Utils.SolicitarNombreLibro;
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
        ValidarUsuarios.AgregarUsuario();

      } else if (opc == 2) {
        ValidarUsuarios.listarUsuarios();

      } else if (opc == 3) {
        ValidarLibros.AgregarLibro();

      } else if (opc == 4) {
        ValidarLibros.ListarLibros();

      } else if (opc == 5) {
        ValidarLibros.existenciaLibro();

      } else if (opc == 6) {
        String name = SolicitarNombreLibro.nombreLibro();
        DisponibilidadLibros.pedirLibro(name);

      } else if (opc == 7) {
        DisponibilidadLibros.returnBookValidation();

      } else if (opc == 8) {
        DisponibilidadLibros.librosDisponibles();

      } else if (opc == 9) {
        DisponibilidadLibros.librosNoDisponibles();

      } else if (opc == 10) {
        break;

      } else {
        System.out.println("Opción no valida intenta nuevamente.");
      }

    }
  }
}