package c008_oop.PolimorfismoExe.E07;

public class Cat extends Animal{

  @Override
  public void showAnimalType(Object animalType) {
    System.out.println("El gato es: " + animalType);
  }
}
