package c10_Extras;

import c008_oop.Classes;

import java.util.Scanner;
/* c008_oop.*;
  Es * lo que nos dice es que va a importar todo lo que encuentre en la carpeta indicada.
 Lo mejor es ir una por una a menos que sepamos que queremos todo el directorio o lo que estemos exportando
 de lo contrario es recomendable ir una por una.*/

public class Extras {

  static String global = "Mouredev";

  public static void main(String[] args) {
    // Extras

    // Concepto null
    String name = "Brais";
    name = null;
    if (name != null) {
      System.out.println(name);
    }

    new Classes();

    // Scanner: Nos permite solicitar datos al usuario por consola.

    var scanner = new Scanner(System.in);
    System.out.print("Ingresa tu edad: ");
    var age = scanner.nextInt();

    System.out.println("Tu edad es: " + age);

    // Scope: ámbito de actuación de las variables.
    // Variables locales: Las que se encuentran dentro de la función ya sea el main y otra función.
    // Variables globales: Son las que se encuentran dentro de la clase padre fuera de las funciones ya sea el main u otras.

    var local = "No se";

    System.out.println(local); // Variable Local
    System.out.println(global); // Variable Global.

    // static: Pertenece a la clase no a la instancia.
    // No es necesario instance.

  }
}
