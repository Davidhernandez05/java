package c01_beginner;

public class VariableAndConstants {
  public static void main(String[] args) {

    // Variables:
    String name = "David";
    int age = 28;
    boolean cierto = true;
    float precio = 2.23f;
    int myInt; // Variable vacía.

    var year = 2025;

    System.out.println("Mi nombre es: " + name + "\nMi edad es: " + age);
    System.out.println(cierto);
    System.out.println(precio);

    name = "MoureDev";
    System.out.println("Mi nombre es: " + name);

    myInt = 10;
    System.out.println(myInt);

    System.out.println(year);

    // Constantes:
    final String EMAIL = "david@gmail.com"; //Las constantes por buenas practicas se deben crear con un nombre todo en mayúsculas.
    System.out.println(EMAIL);

  }
}
