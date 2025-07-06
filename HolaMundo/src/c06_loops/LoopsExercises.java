package c06_loops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LoopsExercises {
  public static void main(String[] args) {
    // 1. Imprime los números del 1 al 10 usando while.
    var contador = 1;

    while (contador <= 10){
      System.out.println(contador);
      contador++;
    }

    // 2. Usa do-while para mostrar todos los valores de un ArrayList.

    var names = new ArrayList<String>();
    contador = 0;
    names.add("David");
    names.add("Brais");
    names.add("Hola mundo");

    do {
      System.out.println("Bienvenido: " + names.get(contador));
      contador++;
    }while (contador < names.size());

    // 3. Imprime los múltiplos de 5 del 1 al 50 usando for.

    for (int i = 1; i <= 10; i++) {
      System.out.println(String.format("5 * %d: %d", i, (5 * i)));
    }

    // 4. Recorre un Array de 5 números e imprime la suma total.

    int[] numbers = {1, 2, 3, 4, 5};
    var total = 0;
    for (Integer num : numbers){
      total += num;
    }
    System.out.println("Total de la suma: " + total);

    // 5. Usa un for para recorrer un Array y mostrar sus valores.

    for (Integer num : numbers){
      System.out.println(num);
    }

    // 6. Usa for-each para recorrer un HashSet y un HashMap.

    var countries = new HashSet<String>();
    var clientes = new HashMap<String, Integer>();

    countries.add("Francia");
    countries.add("Colombia");
    countries.add("Alemania");

    clientes.put("David", 28);
    clientes.put("Miguel", 38);
    clientes.put("Ricardo", 68);

    for (String country : countries){
      System.out.println(country);
    }

    for (Map.Entry<String, Integer> cliente : clientes.entrySet()) {
      System.out.println(cliente);
    }

    // 7. Imprime los números del 10 al 1 (descendiente) con un bucle for.

    for (int i = 10; i >= 1; i--){
      System.out.println(i);
    }

    // 8. Usa continue para saltar los múltiplos de 3 del 1 al 20.

    for (int index = 1; index <= 20; index++) {
      if (index % 3 == 0){
        continue;
      }
      System.out.println(index);
    }

    // 9. Usa break para detener un bucle cuando encuentres un número negativo en un array.

    int[] numbers1 = {1, 2, 10, 50, -1, 100, 200, 300};

    for (Integer number : numbers1){
      if (number < 0){
        break;
      }
      System.out.println(number);
    }

    // 10. Crea un programa que calcule el factorial de un número dado.


    int num1 = 5;
    int total1 = num1;
    var number2 = 0;

    for (int i = num1; i > 0; i--) {

      number2 = i - 1;
      if (number2 == 1){
        number2 = 1;

      } else if (number2 == 0) {
        break;

      }
      total1 = total1 * number2;
    }

    System.out.println(String.format("El total de %d factorial es: %d",num1, total1));
  }
}
