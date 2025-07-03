package c04_conditionals;

public class Conditionals {
  public static void main(String[] args) {
    // Condicionales:

    // IF - Else - Else if:
    var age = 17;

    if (age > 18) {
      System.out.println("Eres mayor de edad.");

    } else if (age == 18) {
      System.out.println("Acabas de cumplir los 18 años de edad.");

    } else {
      System.out.println("Eres menor de edad.");
    }

    // Switch:

    var dia = 1;

    switch (dia) {
      case 1:
        System.out.println("Lunes.");
        break;
      case 2:
        System.out.println("Martes.");
        break;
      case 3:
        System.out.println("Miércoles.");
        break;
      default:
        System.out.println("Dia ingresado no valido.");
    }


  }
}
