package c008_oop;

import c008_oop.Exercisses.Car;

public class Inheritance {
  public static void main(String[] args) {
    //Herencia:
    var animal = new Animal("Samy");
    animal.eat();

    var dog1 = new Dog("Mou", "Pug");
    dog1.eat();
    dog1.razaPerro();

    var cat = new Cat("Max");
    cat.eat();

    var bird = new Bird("Bou");
    bird.eat();
    bird.fly();
  }

  public static class Animal {

    String name;

    public Animal(String name){
      //Si una superclase o padre tiene un constructor sus subclases o hijos también deben tener constructores.
      this.name = name;
    }

    public void eat(){
      System.out.println("El animal con nombre: " + name +" esta comiendo.");
    }
  }

  public static class Dog extends Animal {

    String raza;

    public Dog(String name, String raza) {
      super(name); // Con el súper llamamos a nuestra superclase o padre.
      this.raza = raza;
    }

    public void razaPerro() {
      System.out.println("Mi perro es de raza: " + raza);
    }
  }

  public static class Cat extends Animal {

    public Cat(String name){
      super(name);
    }

    @Override //-> Especifica que se está sobreescribiendo.
    public void eat() {
      // super.eat(); //Super: Hace referencia al padre, a quien hereda.
      System.out.println("El gato con nombre: " + name + " esta comiendo.");
    }
  }

  public static class Bird extends Animal {

    public Bird(String name){
      super(name);
    }

    public void fly() {
      System.out.println("El pajaro " + name + " esta volando.");
    }
  }
}
