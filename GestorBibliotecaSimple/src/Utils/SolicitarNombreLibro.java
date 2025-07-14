package Utils;

import java.util.Scanner;

public class SolicitarNombreLibro {

  public static String nombreLibro() {
    var sc = new Scanner(System.in);
    System.out.print("Ingresa el nombre del libro: ");
    return sc.nextLine();


  }
}
