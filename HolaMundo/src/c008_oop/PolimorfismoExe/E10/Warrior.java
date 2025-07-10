package c008_oop.PolimorfismoExe.E10;

public class Warrior extends Character{

  double ataque = 100;

  @Override
  public void attack() {
    System.out.println("El guerrero hace un daño de: " + ataque);
  }
}
