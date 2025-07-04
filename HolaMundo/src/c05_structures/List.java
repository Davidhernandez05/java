package c05_structures;

import java.util.ArrayList;
import java.util.Arrays;

public class List {
  public static void main(String[] args) {

    //Declaración y creación
    ArrayList<String> names = new ArrayList<>();
    var numbers = new ArrayList<Integer>(); //No puede ser un tipo de dato primitivo.

    //Agregar elementos a una lista:
    names.add("David");
    numbers.add(22);
    numbers.add(28);
    numbers.add(100);

    //Tamaño de una lista:
    System.out.println(names.size());
    System.out.println(numbers.size());

    //Buscar un elemento en concreto en una lista:
    System.out.println("Primer elemento de la lista: " + numbers.getFirst());
    System.out.println("Un elemento en concreto de la lista: " + numbers.get(1));
    System.out.println("Ultimo elemento de la lista: " + numbers.getLast());

    // Imprimir valores de la lista.:
    System.out.println(names);
    System.out.println(numbers);

    //Eliminar dato de una lista:
    numbers.remove(numbers.getFirst());
    System.out.println("Después de eliminar un elemento: " + numbers);

    //Modificar elementos de una lista:
    names.set(0, "Ricardo");
    System.out.println(names);

    //Buscar elementos:
    System.out.println(names.contains("Ricardo"));
    System.out.println(names.contains("a"));

    //Limpiar o eliminar todos los datos de una lista:
    names.clear();
    System.out.println(names.size());

  }
}
