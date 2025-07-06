package c07_Functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Functions {
  public static void main(String[] args) {

    //Funciones:
    sendEmail();

    sumNumbers(2, 2);

    var sum = numbers();
    System.out.println(sum);

    var envio = sendEmail("David", "David@gmail.com");
    System.out.println(envio);

    var names = new ArrayList<String>(Arrays.asList("David", "Miguel", "Alejandra"));
    sendEmail(names);
  }

  //void es para decirle a función que no va a retornar ningún tipo de valor.

  //Función sin parámetros ni retorno:
  public static void sendEmail(){
    System.out.println("Se envía el Email");
  }

  //Función con parámetros:
  public static void sumNumbers(Integer a, Integer b) {
    System.out.println(a + b);
  }

  //Función que retorna algo:
  public static Integer numbers() {
    var a = 40;
    var c = 60;
    var result = a + c;

    return result;
  }

  //Función que recibe parámetros y retorna un valor y adicional cuenta con sobrecarga de funciones:
  //Sobrecarga de funciones quiere decir que hay más de una función con el mismo nombre, pero reciben parámetros diferentes y tienen funcionalidades diferentes.
  public static String sendEmail(String nombre, String email) {
    var send = String.format("Se envío un correo al email: %s a nombre de: %s", email, nombre);
    return send;

  }
  // Sobrecarga pasando un arraylist como parámetro:
  public static void sendEmail(ArrayList<String> names){
    for (String name : names) {
      System.out.println(name);
    }
  }
}
