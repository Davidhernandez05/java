package c008_oop;

public class Polymorphism {

  public static void main(String[] args) {

    // Polimorfismo:
    // Permite que distintos objetos respondan de forma diferente dependiendo del contexto.

    //Polimorfismo por herencia (Sobre escritura):
    var animal = new Animal();
    animal.name = "Leon";
    animal.sound();

    var gato = new Cat();
    gato.name = "Jack";
    gato.sound();

    //Polimorfismo por Sobrecarga ()Sobrecarga de métodos:
    var calculator = new Calculator();
    System.out.println(calculator.sum(3, 5));
    System.out.println(calculator.sum(3.2, 5.4));
  }

  // Polimorfismo por Herencia:
  public static class Animal {
    String name;

    public void sound(){
      System.out.println("El animal: " + name + " esta haciendo un sonido.");
    }
  }

  public static class Cat extends Animal {
    // Esto ya no solo es herencia, sino que es polimorfismo por herencia porque se está modificando algo básico que viene del padre.
    @Override
    public void sound() {
      System.out.println(name + ", Hace: Miau.");
    }
  }

  //Polimorfismo por Sobrecarga:
  public static class Calculator {

    public int sum(int a, int b) {
      return a + b;
    }

    public int sum(int a, int b, int c) {
      return a + b + c;
    }

    public double sum(double a, double b) {
      return a + b;
    }
  }
}
