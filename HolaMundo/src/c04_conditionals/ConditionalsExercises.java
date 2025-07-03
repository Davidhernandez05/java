package c04_conditionals;

public class ConditionalsExercises {
  public static void main(String[] args) {
    // 1. Establece la edad de un usuario y muestra si puede votar (mayor o igual a 18).
    var userage = 18;

    if (userage >= 18) {
      System.out.println("Eres mayor de edad por lo tanto puedes votar.");
    }else {
      System.out.println("Eres menor de edad no puedes votar.");
    }

    // 2. Declara dos números y muestra cuál es mayor, o si son iguales.

    var a = 10;
    int b = 10;

    if (a > b) {
      System.out.println(String.format("El número %d, es mayor que el numero %d.", a, b));
    } else if (a == b) {
      System.out.println("Los números son iguales: " + a);
    }else {
      System.out.println(String.format("El número %d, es mayor que el numero %d.", b, a));
    }

    // 3. Dado un número, verifica si es positivo, negativo o cero.

    var numero = -10;

    if (numero < 0) {
      System.out.println(String.format("El número %d, es negativo.", numero));
    } else if (numero == 0) {
      System.out.println("El número es cero.");
    }else {
      System.out.println(String.format("El número %d, es positivo.", numero));
    }

    // 4. Crea un programa que diga si un número es par o impar.

    var numeroBuscar = 1;

    if (numeroBuscar % 2 == 0) {
      System.out.println(String.format("El número %d, es par.", numeroBuscar));
    }else {
      System.out.println(String.format("El número %d, es impar.", numeroBuscar));
    }

    // 5. Verifica si un número está en el rango de 1 a 100.

    var c = 99;

    if (c >= 1 && c <= 100){
      System.out.println(String.format("El número %d, se encuentra entre el rango del 1 y el 100.", c));
    }else {
      System.out.println("El numero no es valido.");
    }

    // 6. Declara una variable con el día de la semana (1-7) y muestra su nombre con switch.

    int dia = 5;

    switch (dia) {
      case 1:
        System.out.println("Lunes");
        break;
      case 2:
        System.out.println("Martes");
        break;
      case 3:
        System.out.println("Miércoles");
        break;
      case 4:
        System.out.println("Jueves");
        break;
      case 5:
        System.out.println("Viernes");
        break;
      case 6:
        System.out.println("Sábado");
        break;
      case 7:
        System.out.println("Domingo");
        break;
      default:
        System.out.println("Día no valido.");
        break;
    }

    // 7. Simula un sistema de notas: muestra "Sobresaliente", "Aprobado" o "System.out.println("Domingo");" según la nota (0-100).

    int nota = 60;

    if (nota >= 0 && nota < 60){
      System.out.println(String.format("La nota: %d, es Suspendido.", nota));

    } else if (nota >= 60 && nota < 90 ) {
      System.out.println(String.format("La nota: %d, es Sobresaliente.", nota));

    } else if (nota >= 90 && nota <= 100) {
      System.out.println(String.format("La nota: %d, es Aprobado.", nota));

    }else {
      System.out.println("Nota no valida.");
    }

    // 8. Escribe un programa que determine si puedes entrar al cine: debes tener al menos 15 años o ir acompañado.

    var age = 13;
    var companion = true ;

    if (age >= 15){
      System.out.println(String.format("Tienes %d, por lo cual puedes ingresar.", age));

    } else if (age < 15 && companion) {
      System.out.println(String.format("Tienes %d, pero vienes con acompañante por lo cual puedes ingresar.", age));

    }else {
      System.out.println(String.format("Tienes %d, debes traer acompañante para ingresar.", age));
    }

    // 9. Crea un programa que diga si una letra es vocal o consonante.

    var letra = "A";
    var vocales = "aeiou";

    if (vocales.contains(letra.toLowerCase())){
      System.out.println(String.format("la letra es: %s, es una vocal.", letra));
    }else {
      System.out.println(String.format("la letra es: %s, es consonante.", letra));
    }

    // 10. Usa tres variables a, b, c y muestra cuál es el mayor de las tres.

    var num = 40;
    var num1 = 40;
    var num2 = 50;

    if (num > num1 && num > num2) {
      System.out.println("El numero mayor es: " + num);
    } else if (num1 > num && num1 > num2) {
      System.out.println("El numero mayor es: " + num1);
    } else if (num2 > num && num2 > num1) {
      System.out.println("El numero mayor es: " + num2);
    } else {
      System.out.println("Los tres números son iguales: " + num);
    }
  }
}
