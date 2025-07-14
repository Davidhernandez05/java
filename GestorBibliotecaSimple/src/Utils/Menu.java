package Utils;

import java.util.Scanner;

public class Menu {

  public static int menu() {


    System.out.println("Menu: ");
    System.out.println("1. Agregar un nuevo libro al sistema.");
    System.out.println("2. Listar todos los libros en el sistema.");
    System.out.println("3. Agregar un nuevo usuario al sistema.");
    System.out.println("4. Listar todos los usuarios en el sistema.");
    System.out.println("5. Buscar un libro.");
    System.out.println("6. Pedir libro.");
    System.out.println("7. Regresar libro.");
    System.out.println("8. ");
    System.out.println("9. Salir del programa.");

    var sc = new Scanner(System.in);
    System.out.print("Ingresa la opción: ");

    return sc.nextInt();

  }
}
