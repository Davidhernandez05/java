package c06_loops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Loops {
  public static void main(String[] args) {
    //Loops:

    //For: Controlado por contador
    for (int i = 0; i < 5; i++) {
      System.out.println("Hola Java!. " + (i + 1));
    }

    //Recorrer una estructura:
    var names = new ArrayList<String>();
    names.add("David");
    names.add("Juliana");
    names.add("Daniela");
    names.add("Marco");
    names.add("Miguel");

    for (int index = 0; index < names.size(); index++) {
      System.out.println(names.get(index));
    }

    //For-Each -> esta es la forma correcta de recorrer estructuras de datos.
    for (String name : names) {
      System.out.println(name);
    }

    var numbers = new HashSet<Integer>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(10);

    for (Integer number : numbers){
      System.out.println(number);
    }

    var users = new HashMap<Integer, String>();
    users.put(1, "Ricardo");
    users.put(2, "John");
    users.put(3, "Mario");
    users.put(4, "King");
    users.put(5, "Martin");
    users.put(6, "Mark");

    for (Map.Entry<Integer, String> user : users.entrySet()) {
      System.out.println(user.getKey());
      System.out.println(user.getValue());
      System.out.println(user);
    }

    //While:
    var contador = 0;

    while (contador < 5) {
      System.out.println("hola mundo en java con ciclo While.");
      contador++;
    }

    contador = 0;
    while (contador < names.size()) {
      System.out.println(names.get(contador));

      if (names.get(contador).equals("Daniela")){
        System.out.println("hola: " + names.get(contador));
      }
      if (names.get(contador).equals("Marco")) {
        System.out.println("Adios: " + names.get(contador));
        break; // Hace que el loop se rompa y nos saca de este.
      }
      contador++;
    }

    //Do-While -> Siempre se bva a ejecutar mínimo una vez.
    contador = 0;
    do {
      //Esto se ejecuta mínimo una vez y después comprueba el criterio.
      System.out.println(names.get(contador));
      contador++;
    }while (contador < 3);

    //continue: Fuerza la siguiente ejecución del loop.
    for (int i = 0; i < 10; i++){
      if (i == 3 || i == 7){
        continue; // Por lo cual omite todo lo que esta después de el.
      }
      System.out.println(i);
    }
  }
}
