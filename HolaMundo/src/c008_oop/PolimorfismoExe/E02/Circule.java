package c008_oop.PolimorfismoExe;

public class Circule extends Shape{

  double radio;

  public Circule(double radio){
    this.radio = radio;
  }

  @Override
  public void calculateArea() {
    final double pi = 3.14;
    double total = (pi * (radio * radio));

    System.out.println("El area del circulo es de: " + total);
  }
}
