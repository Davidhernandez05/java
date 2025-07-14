package Utils;

import Clases.Biblioteca;
import Clases.Libros;
import Clases.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidarUsuarios {

  static ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
  static ArrayList<Biblioteca> listaBiblioteca = new ArrayList<>();

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
    System.out.println("Lista de usuarios: ");
    for (Usuarios usuario : listaUsuarios) {
      System.out.println(String.format("ID: %d, Usuario: %s", usuario.getId(), usuario.getName()));
    }
  }

  public static boolean buscarUsuario() {
    var sc = new Scanner(System.in);
    System.out.print("Ingresa el email del usuario que vas a buscar: ");
    var emailUser = sc.nextLine();

    for (Usuarios usuario : listaUsuarios) {
      if (usuario.getEmail().toLowerCase().trim().equals(emailUser)) {
        return true;
      }
    }
    return false;
  }
}
