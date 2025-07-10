package c008_oop.PolimorfismoExe.E04;

public class Greeter {

  public void greet(){
    System.out.println("Hola.");
  }

  public void greet(String name) {
    System.out.println("Hola: " + name + ".");
  }
}
