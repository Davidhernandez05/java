package c008_oop.PolimorfismoExe.E09;

public class Product {

  double price;

  public Product(double price) {
    this.price = price;
  }


  public double getPrice(double discount) {
    System.out.println("El producto ingresado no tiene descuento.");
    return price;
  }
}
