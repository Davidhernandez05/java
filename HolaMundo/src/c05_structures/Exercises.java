package c05_structures;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercises {
  public static void main(String[] args) {
    // 1. Crea un Array con 5 valores e imprime su longitud.
    int[] numbers = {1, 2, 3, 4, 5};
    System.out.println(numbers.length);

    // 2. Modifica uno de los valores del Array e imprime el valor del índice antes y después de modificarlo.
    System.out.println("Antes de modificar el valor en el indice 0: " + numbers[0]);
    numbers[0] = 10;
    System.out.println("Después de modificar el valor en el indice 0: " + numbers[0]);

    // 3. Crea un ArrayList vacío.
    var names = new ArrayList<String>();

    // 4. Añade 4 valores al ArrayList y elimina uno a continuación.
    names.add("David");
    names.add("Miguel");
    names.add("Juliana");
    names.add("Maria");

    System.out.println(names.size());
    names.remove(2);
    System.out.println(names.size());

    // 5. Crea un HashSet con 2 valores diferentes.
    var age = new HashSet<Integer>();
    age.add(20);
    age.add(11);

    System.out.println(age);

    // 6. Añade un nuevo valor repetido y otro sin repetir al HashSet.
    age.add(20);
    age.add(60);

    System.out.println(age);

    // 7. Elimina uno de los elementos del HashSet.

    age.remove(60);
    System.out.println(age);

    // 8. Crea un HashMap donde la clave sea un nombre y el valor el número de teléfono. Añade tres contactos.
    var phones = new HashMap<String, Integer>();

    phones.put("David", 34020309);
    phones.put("Miguel", 32020309);
    phones.put("Juliana", 34053509);

    System.out.println(phones);

    // 9. Modifica uno de los contactos y elimina otro.

    phones.replace("David", 311441590);
    phones.remove("Miguel");

    System.out.println(phones);

    // 10. Dado un Array, transfórmalo en un ArrayList, a continuación en un HashSet y finalmente en un HashMap con clave y valor iguales.

    String[] countries = {"Colombia", "España", "Mexico"};
    System.out.println(countries.getClass().isArray());

    var paises = Arrays.asList(countries);
    System.out.println(paises.getClass().getSimpleName());

    var setpaises = new HashSet<String>(paises);
    System.out.println(setpaises);
    System.out.println(setpaises.getClass().getSimpleName());

    HashMap<String, String> mapCountries = setpaises.stream().collect(Collectors.toMap(
        pais -> pais,
        pais -> pais,
        (a,b) -> b, //Específica como resolver conflictos si hay valores duplicados.
        HashMap::new //Asegura que el resultado sea un HashMap, y no solo un MAP
    ));

    System.out.println(mapCountries);
    System.out.println(mapCountries.getClass().getSimpleName());
  }
}
