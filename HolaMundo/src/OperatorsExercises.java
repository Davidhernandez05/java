public class OperatorsExercises {

  public static void main(String[] args) {
    // 1. Crea una variable con el resultado de cada operación aritmética.
    var a = 20;
    final var b = 6;

    var resultSum = a + b;
    var resultRest = a - b;
    var multiplication = a * b;
    var resultDivision = a / b;
    var residuo = a % b;

    System.out.println(resultSum);
    System.out.println(resultRest);
    System.out.println(multiplication);
    System.out.println(resultDivision);
    System.out.println(residuo);

    // 2. Crea una variable para cada tipo de operación de asignación.
    a = b;
    System.out.println(a);

    a += 1;
    System.out.println(a);

    a -= 1;
    System.out.println(a);

    a *= 2;
    System.out.println(a);

    a /= 2;
    System.out.println(a);

    a %= 2;
    System.out.println(a);

    // 3. Imprime 3 comparaciones verdaderas con diferentes operadores de comparación.
    System.out.println(true && true);
    System.out.println(true || false);
    System.out.println(true || true);

    // 4. Imprime 3 comparaciones falsas con diferentes operadores de comparación.

    System.out.println(false && false);
    System.out.println(false && true);
    System.out.println(false || false);

    // 5. Utiliza el operador lógico and.
    System.out.println(false && true);

    // 6. Utiliza el operador lógico or.
    System.out.println(false || true);

    // 7. Combina ambos operadores lógicos.
    System.out.println(true && true || true && false);

    // 8. Añade alguna negación.
    System.out.println(!true);

    // 9. Imprime 3 ejemplos de uso de operadores unarios.
    a = 10;
    System.out.println(a++);
    System.out.println(--a);
    System.out.println(+a);

    // 10. Combina operadores aritméticos, de comparación y lógicos.
    System.out.println(5 * 3 >= 10 || a + 2 == 20);
  }
}
