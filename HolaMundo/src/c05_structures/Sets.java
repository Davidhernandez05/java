package c05_structures;

import java.util.HashSet;

public class Sets {
  public static void main(String[] args) {
    // Set es una estructura desordenada -> Sirve para acceder a los datos de una forma muy rápida.
    // Declaración y creación de Set:
    HashSet<Integer> age = new HashSet<>();
    var names = new HashSet<String>();

    // Agregar Elementos:
    age.add(2);
    age.add(3);
    age.add(4);
    age.add(5);
    System.out.println(age);

    names.add("Miguel");
    names.add("David");
    names.add("Brais");
    System.out.println(names);

    // Tamaño de un set:
    System.out.println(names.size());

    //Buscar Elementos:
    System.out.println(names.contains("David"));
    System.out.println(names.contains("a"));

    //Eliminar elementos:
    names.remove("Miguel");
    System.out.println(names.size());
    System.out.println(names);

    //Eliminar todos los elementos de un SET:
    System.out.println(age);
    age.clear();
    System.out.println(age);
    System.out.println(age.size());

    //Conjuntos:
    var countries = new HashSet<String>();
    countries.add("Colombia");
    countries.add("España");
    countries.add("Mexico");

    //Agregar un set a otro.
    names.addAll(countries);  //Tener en cuenta que para unir dos estructuras deben tener el mismo tipo de dato.
    System.out.println(names);

    //Eliminar los elementos que comunes:
    names.removeAll(countries);
    System.out.println(names);

    //Dejar los elementos comunes de ambos SET:
    names.addAll(countries);
    System.out.println(names);
    names.retainAll(countries);
    System.out.println(names);
  }
}
