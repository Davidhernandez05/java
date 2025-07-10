package c008_oop.PolimorfismoExe.E10;

public class Mage extends Character{
  double ataque = 50;

  @Override
  public void attack() {
    System.out.println("El mago hace un daño de: " + ataque);
  }
}
