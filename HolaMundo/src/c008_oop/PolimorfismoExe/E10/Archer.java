package c008_oop.PolimorfismoExe.E10;

public class Archer extends Character{
  double ataque = 70;

  @Override
  public void attack() {
    System.out.println("El arquero hace un daño de: " + ataque);
  }
}
