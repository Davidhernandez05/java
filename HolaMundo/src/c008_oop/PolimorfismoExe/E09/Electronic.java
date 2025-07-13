package c008_oop.PolimorfismoExe.E09;

public class Electronic extends Product{

  String electronicName;

  public Electronic (double price, String electronicName) {
    super(price);
    this.electronicName = electronicName;
  }

  @Override
  public double getPrice(double discount) {
    double discountPercentage = (price * discount) / 100;
    System.out.println(String.format("El descuento del electrónico: %s es de: %.00f%%", electronicName, discount));
    return price - discountPercentage;
  }
}
