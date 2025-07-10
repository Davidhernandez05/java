package c008_oop.PolimorfismoExe.E09;

public class Book extends Product{

  String bookName;

  public Book (double price, String bookName) {
    super(price);
    this.bookName = bookName;
  }

  @Override
  public double getPrice(double discount) {
    double discountPercentage = (price * discount) / 100;
    System.out.println(String.format("El descuento del libro: %s es de: %.00f%%", bookName, discount));
    return price - discountPercentage;
  }
}
