import java.lang.reflect.Type;

public class DataType {
  public static void main(String[] args) {
    // Tipo de datos primitivos:
    int myInt = 43;
    System.out.println(myInt);

    double myDouble = 1.78; // long, byte
    System.out.println(myDouble);

    char myChar = 'a';
    System.out.println(myChar);

    float myFloat = 1.89f;
    System.out.println(myFloat);

    boolean myBolean = true;
    System.out.println(myBolean);

    String myString = "David"; //No es primitivo en java, pero en otros lenguajes su puede ser primitivo.
    System.out.println(myString);

    // Tipo de Dato en Tiempo de Compilación si es una clase.
    System.out.println(myString.getClass().getSimpleName());
  }
}
