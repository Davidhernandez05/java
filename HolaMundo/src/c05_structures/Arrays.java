package c05_structures;

public class Arrays {
  public static void main(String[] args) {
    // Declaración y creación:
    int[] numers1 = new int[3];
    int[] numbers = {1, 2, 3, 4, 5};
    System.out.println(numbers[4]);

    String[] names = {"David", "Ricardo", "Miguel", "Luis"};

    // Acceso:
    System.out.println(numbers[3]);
    System.out.println(names[0]);

    //modificar datos:
    names[3] = "Brais";
    System.out.println(names[3]);

    numers1[0] = 2;
    numers1[2] = 12;
    System.out.println(numers1[2]);

    // No podemos varios el tamaño de los arrays ni tampoco eliminar datos lo que si podemos hacer es limpiar los datos de un espacio asignado:
    names[3] = null;
    System.out.println(names[3]);
    System.out.println(names.length);

    boolean[] booleans = new boolean[5]; //Los booleans si se les asigna el valor false al momento de inicializarlos.
    System.out.println(booleans[4]);
  }
}
