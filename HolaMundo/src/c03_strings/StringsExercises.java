package c03_strings;

public class StringsExercises {
  public static void main(String[] args) {
    var name = "El alquimista";

    // 1. Concatena dos cadenas de texto.
    System.out.println("Hola " + "mundo.");

    // 2. Muestra la longitud de una cadena de texto.
    System.out.println(name.length());

    // 3. Muestra el primer y último carácter de un string.
    System.out.println(name.charAt(0));
    System.out.println(name.charAt(name.length() -1));

    // 4. Convierte a mayúsculas y minúsculas un string.
    System.out.println(name.toLowerCase());
    System.out.println(name.toUpperCase());

    // 5. Comprueba si una cadena de texto contiene una palabra concreta.
    System.out.println(name.contains("El"));

    // 6. Formatea un string con un entero.
    var year = 1988;
    System.out.println(String.format("%s, se publico en: %d", name, year));

    // 7. Elimina los espacios en blanco al principio y final de un string.
    name = "  Despues  ";
    System.out.println(name.trim());

    // 8. Sustituye todos los espacios en blanco de un string por un guión (-).
    System.out.println(name.replace(" ", "-"));

    // 9. Comprueba si dos strings son iguales.
    System.out.println(name.trim().equals("Despues"));

    // 10. Comprueba si dos strings tienen la misma longitud.
    System.out.println(name.trim().length() == "david".length());
    System.out.println(name.trim().length() == "asdfghj".length());
  }
}
