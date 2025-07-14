package Utils;

import Clases.Libros;
import Clases.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidarUsuarios {

  static ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();

  public static void AgregarUsuario() {
    var sc = new Scanner(System.in);
    System.out.print("Ingresa el nombre del usuario: ");
    var name = sc.nextLine();

    sc = new Scanner(System.in);
    System.out.print("Ingresa el nombre del usuario: ");
    var email = sc.nextLine();

    listaUsuarios.add(new Usuarios(name, email));
    System.out.println("Se creo correctamente al usuario: " + name);
  }

  public static void listarUsuarios() {
    for (Usuarios usuario : listaUsuarios) {
      System.out.println(usuario.getName());
    }
  }
}
