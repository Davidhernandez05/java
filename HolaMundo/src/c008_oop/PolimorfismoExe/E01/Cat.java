package c008_oop.PolimorfismoExe.E01;

public class Cat extends Animal {

  public Cat (String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.printf("El Gato: %s hace Miau.\n", name);
  }
}
