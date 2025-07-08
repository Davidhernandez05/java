package c008_oop;

public class Abstraction {
  public static void main(String[] args) {
    // Abstracción:
    // Oculta la implementación y muestro solo lo esencial.

    //Clase abstracta: No se deja instancia la oculta.
    var gato = new Cat();
    var perro = new Dog();
    gato.sleep();
    gato.sound();
    perro.sleep();
    perro.sound();

    // Interface:
    var pajaro = new Bird();
    var bat = new Bat();
    pajaro.fly();
    bat.fly();
    bat.fly2();
  }
  // Clase abstracta:
  public static abstract class Animal {
    public abstract void sound(); //Esto crea el método, pero cada uno de los que lo heredan tienen que encargarse de crear su funcionalidad.

    public void sleep(){
      System.out.println("El animal esta durmiendo.");
    }
  }

  public static class Cat extends Animal {

    @Override
    public void sound() {
      System.out.println("El gato hace miau.");
    }

    @Override
    public void sleep() {
      System.out.println("El gato es durmiendo.");
    }
  }
  public static class Dog extends Animal {

    @Override
    public void sound() {
      System.out.println("El perro hace guau.");
    }
  }

  // Interface:
  public interface Flying {// Solo nos sirve para definir los métodos.
    void fly();
  }

  public interface Flying2 {// Solo nos sirve para definir los métodos.
    void fly2();
  }

  public static class Bird extends Animal implements Flying {

    @Override
    public void fly() {
      System.out.println("El pájaro esta volando.");
    }

    @Override
    public void sound() {
      System.out.println("El pajaro hace pio.");
    }
  }

  public static class Bat extends Animal implements Flying, Flying2 {

    @Override
    public void sound() {
      System.out.println("Soy batman!.");
    }

    @Override
    public void fly() {
      System.out.println("El murciélago esta volando.");
    }

    @Override
    public void fly2() {
      System.out.println("Vuela Batman.");
    }
  }
}
