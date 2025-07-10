package c008_oop.PolimorfismoExe.E03;

public class Printer {

  public void print(String name) {
    System.out.println("Tu nombre es: " + name);
  }

  public void print(int age) {
    System.out.println("Tu edad es: " + age);
  }

  public void print(double stature) {
    System.out.println("Tu estatura es: " + stature);
  }

  public void print(String name, int age) {
    System.out.println("Tu nombre es: " + name + " y tu edad es: " + age);
  }
}
