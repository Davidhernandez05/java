package c008_oop.PolimorfismoExe.E01;

public class Animal {

  String name;

  public Animal(String name){
    this.name = name;
  }

  public void makeSound() {
    System.out.println("El animal esta haciendo un sonido.");
  }
}
