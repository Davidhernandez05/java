package c03_strings;

import java.util.Locale;

public class Strings {
  public static void main(String[] args) {
    //Cadenas de texto:

    // Declaración Strings
    var nombre = "David";
    String apellido = "Hernandez";

    // Operaciones básicas:
    System.out.println(nombre + " " + apellido);

    // Longitud
    System.out.println(nombre.length());

    // Obtener carácter:
    System.out.println(nombre.charAt(3));
    System.out.println(nombre.charAt(nombre.length() -1));

    // Subcadena:
    System.out.println(nombre.substring(1));
    System.out.println(nombre.substring(1, 4));

    // Mayúsculas y minúsculas:
    System.out.println(apellido.toUpperCase());
    System.out.println(apellido.toLowerCase());

    // Comprobar si contiene:
    System.out.println("Hola Java".contains("a")); //Tiene que ser una coincidencia completa -> No es lo mismo a que A.

    // Comparación:
    System.out.println(nombre.equals(apellido)); //Tiene que ser una coincidencia completa -> No es lo mismo a que A.
    System.out.println(nombre.equalsIgnoreCase("david"));

    // Trim:
    System.out.println(" Hola me llamo David ".trim()); // Elimina espacios en blanco al inicio y al final.

    // Reemplazar carácteres
    System.out.println(" Hola me llamo David ".replace(" ", "_"));
    System.out.println(" Hola me llamo David ".replace("David", "Brais"));

    // Format:
    var age = 37;
    System.out.println(String.format("Hola, mi nombre es: %s.\nTengo %d años", nombre, age));
  }
}
