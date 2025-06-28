public class operators {

  public static void main(String[] args) {

    //Operadores:
    //Aritméticos:
    var a = 6;
    var b = 4;

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b); //Módulo: Lo que sobra del resultado de la división

    //Asignación:
    a = b;
    System.out.println(a);

    a = b * 2;
    System.out.println(a);

    a += 1;
    System.out.println(a);

    a -= 2;
    System.out.println(a);

    a *= 2;
    System.out.println(a);

    a /= 2;
    System.out.println(a);

    a %= 2;
    System.out.println(a);

    //Relacionales o Comparación:
    System.out.println(a == b);
    System.out.println(a == 1);
    System.out.println(a != b);
    System.out.println(a > b);
    System.out.println(a >= b);
    System.out.println(a < b);
    System.out.println(a <= b);

    //Lógicos:
    // AND:
    System.out.println(true && true);
    System.out.println(true && false);
    System.out.println(false && true);
    System.out.println(false && false);

    //OR:
    System.out.println(true || true);
    System.out.println(true || false);
    System.out.println(false || true);
    System.out.println(false || false);

    //Negación:
    System.out.println(!true);

    // Unarios:
    System.out.println(+b);
    System.out.println(-b);
    System.out.println(++b);
    System.out.println(--b);



  }
}
