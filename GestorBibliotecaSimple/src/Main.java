import Clases.Libros;
import Utils.ValidarLibros;
import Utils.ValidarUsuarios;

import java.util.ArrayList;

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
        var existe = ValidarLibros.buscarLibro();
        if (existe) {
          System.out.println("El libro si se encuentra en nuestra Base de Datos.");
        }else {
          System.out.println("El libro no se encuentra en nuestra Base de Datos.");
        }
      } else if (opc == 7) {
        break;
      } else {
        System.out.println("Opción no valida intenta nuevamente.");
      }

    }
  }
}