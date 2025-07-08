package c008_oop.AccessExercises;

public class Temperature {
  private double celsius;

  public Temperature(double celsius) {
    this.setCelsius(celsius);
  }

  public void setCelsius(double celsius) {
    if (celsius >= -100 && celsius <= 100){
      this.celsius = celsius;
    }else {
      System.out.println("Temperatura ingresada no valida.");
    }
  }

  public double getCelsius() {
    return celsius;
  }
}
