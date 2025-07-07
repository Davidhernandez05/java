package c008_oop;

import c008_oop.Exercisses.BankAccount;

public class AccessModifiers {
  public static void main(String[] args) {
    //Encapsulamiento (Modificadores de acceso):
    // Nos permite proteger los datos de una clase para controlar su acceso desde fuera.

    var cuenta1 = new BankAccount("BN929234", 500, 11);

    // GET: nos permite visualizar los datos de una variable privada.
    System.out.println("Su numero de cuenta es: " + cuenta1.getShowIdAccount());

    // SET:
    System.out.println(cuenta1.getAge());
    cuenta1.setAge(12); //Nos permite modificar el valor de una variable privada, pero no puede ser constante.
    System.out.println(cuenta1.getAge()); //Nos permite visualizar el valor de una variable privada.

  }
}
