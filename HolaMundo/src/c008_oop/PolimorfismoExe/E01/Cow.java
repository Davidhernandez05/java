package c008_oop.PolimorfismoExe.E01;

public class Cow extends Animal{

  public Cow(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.printf("El baca: %s hace Muu.\n", name);
  }
}
