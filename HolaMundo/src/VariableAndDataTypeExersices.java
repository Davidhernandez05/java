public class VariableAndDataTypeExersices {

  public static void main(String[] args) {
    // 1. Declara una variable de tipo String y asígnale tu nombre.
    String name = "David";
    System.out.println(name);

    // 2. Crea una variable de tipo int y asígnale tu edad.
    var age = 27;
    System.out.println(age);

    // 3. Crea una variable double con tu altura en metros.
    var altura = 1.75;
    System.out.println(altura);

    // 4. Declara una variable de tipo boolean que indique si te gusta programar.
    boolean programar = true;
    System.out.println(programar);

    // 5. Declara una constante con tu email.
    final var EMAIL = "David@gmail.com";
    System.out.println(EMAIL);

    // 6. Crea una variable de tipo char y guárdale tu inicial.
    char inicial = 'D';
    System.out.println(inicial);

    // 7. Declara una variable de tipo String con tu país, y a continuación cambia su valor y vuelve a imprimirla.
    String pais = "España";
    pais = "Colombia";
    System.out.println(pais);

    // 8. Crea una variable int llamada a, otra b, e imprime la suma de ambas.
    int a = 10;
    var b = 5;
    System.out.println(a + b);

    // 9. Imprime el tipo de dos variables creadas anteriormente.
    System.out.println(EMAIL.getClass().getSimpleName());
    System.out.println(pais.getClass().getSimpleName());

    // 10. Intenta declarar una variable sin inicializarla y luego asígnale un valor antes de imprimirla.
    String bookName;
    bookName = "Hábitos Atómicos";
    System.out.println(bookName);
  }
}
