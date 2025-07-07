package c008_oop.Exercisses;

public class Product {
  public String nameProduct;
  public double priceProduct;

  public Product(String nameProduct, double priceProduct){
    this.nameProduct = nameProduct;
    this.priceProduct = priceProduct;
  }

  public void finalPrice(double discount){
    double result = (discount / 100) * priceProduct;
    double price = priceProduct - result;
    System.out.println("El precio final del producto es de: " + price);
  }
}
