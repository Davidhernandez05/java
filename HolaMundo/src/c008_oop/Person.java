package c008_oop;

public class Person {
  // Atributos:
  String name;
  int age;

  // Constructor:
  public Person(String name, int age) {
    this.name = name; // this hace referencia al contexto de la clase.
    this.age = age; // El this hace referencia a lo que está en la clase y no a lo que solicitamos como parámetros.
  }

  // Funciones o métodos en una clase.
  public void sayHello(){
    System.out.println("Hola, soy " + name + " Y tengo " + age + " años.");
  }

}
