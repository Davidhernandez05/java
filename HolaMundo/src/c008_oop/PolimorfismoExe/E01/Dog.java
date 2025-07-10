package c008_oop.PolimorfismoExe.E01;

public class Dog extends Animal {

  public Dog (String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.printf("El perro: %s hace Guau.\n", name);
  }
}
