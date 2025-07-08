package c008_oop.AccessExercises;

public class Product {
  private double price;

  public Product(double price) {
    this.setPrice(price);
  }

  public void setPrice(double price) {
    if (price > 0) {
      this.price = price;
    }else {
      System.out.println("El precio ingresado no es valido.");
    }
  }

  public double getPrice() {
    return price;
  }
}
