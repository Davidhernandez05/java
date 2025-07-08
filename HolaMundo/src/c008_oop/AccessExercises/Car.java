package c008_oop.AccessExercises;

public class Car {
  private int speed;

  public Car (int speed){
    this.setSpeed(speed);
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void accelerate(int amount) {
    if (amount > 0){
      speed += amount;
      if (speed > 0 && speed <= 120) {
        System.out.println("Tu velocidad actual es de: " + speed);
      } else if (speed > 120) {
        System.out.println("Tu velocidad actual es de: 120, no puede aumentar mas.");
      }
    }else {
      System.out.println("El auto no esta acelerando.");
    }
  }

  public void brake(int amount) {
    if (amount > 0) {
      speed -= amount;
      if (speed <= 0) {
        System.out.println("El auto se detuvo.");
      }else {
        System.out.println("Tu velocidad actual es de: " + speed);
      }
    }else {
      System.out.println("Valor ingresado no valido.");
    }
  }
}
