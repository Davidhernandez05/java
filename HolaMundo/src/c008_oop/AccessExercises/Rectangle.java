package c008_oop.AccessExercises;

public class Rectangle {
  private double width;
  private double height;

  public Rectangle(double width, double height) {
    this.setHeight(height);
    this.setWidth(width);
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double calculateArea() {
    return width * height;
  }
}
