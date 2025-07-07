package c008_oop.Exercisses;

public class Car {
  public String brand;
  public String model;

  public Car(String brand, String model){
    this.brand = brand;
    this.model = model;
  }

  public void showData(){
    System.out.println("Marca: " + brand + "\n" + "Modelo: " + model);
  }
}
