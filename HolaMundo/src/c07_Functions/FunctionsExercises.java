package c07_Functions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class FunctionsExercises {
  public static void main(String[] args) {

    // 1
    welcome();

    // 2
    greetPerson("David");

    // 3
    System.out.println(subtractNumbers(100, 77));

    // 4
    cuadradoNumero(50);

    // 5
    parImpar(1);

    // 6

    if (adult(17)){
      System.out.println("Tienes acceso debido a que eres mayor de edad.");
    }else {
      System.out.println("No tienes acceso debido a que eres menor de edad.");
    }

    // 7
    var cadena = "Hola";
    System.out.println(String.format("La longitud de la cadena: %s, es de: %d caracteres.", cadena, longCadena(cadena)));

    // 8
    var df = new DecimalFormat("00.00"); //Creamos una variable con el nuevo formato de decimal.
    Integer[] num = {1, 23, 40};
    System.out.println(new DecimalFormat("00.00").format(media(num))); // Se puede de ambas formas y de ambas funciona.
    System.out.println(df.format(media(num)));

    // 9
    System.out.println(factorial(5));

    // 10
    var nombres = new ArrayList<String>(Arrays.asList("David", "Miguel", "Angel", "Andres"));
    recorrerLista(nombres);

  }

  // 1. Crea una función que imprima "¡Te doy la bienvenida al curso de Java desde cero!".

  public static void welcome() {
    System.out.println("Te doy la bienvenida al curso de java desde cero!.");
  }

  // 2. Escribe una función que reciba un nombre como parámetro y salude a esa persona.

  public static void greetPerson(String name){
    System.out.println("Hola: " + name);
  }

  // 3. Haz un método que reciba dos números enteros y devuelva su resta.

  public static int subtractNumbers(int num1, int num2){
    return num1 - num2;
  }

  // 4. Crea un método que calcule el cuadrado de un número (n * n).

  public static void cuadradoNumero(int num1) {
    var result = num1 * num1;
    System.out.println(String.format("%d al cuadrado es: %d", num1, result));
  }

  // 5. Escribe una función que reciba un número y diga si es par o impar.

  public static void parImpar(int num){
    if (num % 2 == 0){
      System.out.println(String.format("El numero: %d es par.", num));
    }else {
      System.out.println(String.format("El numero: %d es impar.", num));
    }
  }

  // 6. Crea un método que reciba una edad y retorne true si es mayor de edad (y false en caso contrario).

  public static boolean adult (int age) {
    if (age <= 17){
      return false;
    }
    return true;
  }

  // 7. Implementa una función que reciba una cadena y retorne su longitud.

  public static int longCadena (String cadena){
    return cadena.length();
  }

  //  8. Crea un método que reciba un array de enteros, calcula su media y lo retorna.

  public static float media(Integer[] enteros) {
    var longitud = enteros.length;
    float suma = 0f;

    for (Integer entero : enteros) {
      suma += entero;
    }

    return suma / longitud;
  }

  // 9. Escribe un método que reciba un número y retorna su factorial.

  public static int factorial(int num) {
    int contador = num;
    int result = num;
    int num2 = num;

    while (contador >= 0) {
      num2 -= 1;
      if (num2 == 0){
        break;
      }
      result *= num2;
      contador--;

    }
    return result;
  }

  // 10. Crea una función que reciba un ArrayList<String> y lo recorra mostrando cada elemento.

  public static void recorrerLista(ArrayList<String> lista){
    for (String name : lista){
      System.out.println(name);
    }
  }
}
