package c008_oop.PolimorfismoExe.E02;

public class Rectangle extends Shape{

  double height;
  double base;

  public Rectangle(double base, double height){
    this.base = base;
    this.height = height;
  }

  @Override
  public void calculateArea() {
    double area = base * height;
    System.out.println("El area del rectángulo es de: " + area);
  }
}
