package c008_oop.Exercisses;

import java.text.DecimalFormat;

public class Rectangle {
  double base;
  double altura;
  double resultado;

  public Rectangle(double base, double altura){
    this.base = base;
    this.altura = altura;
  }

  public void area(){
    var formatoDecimal = new DecimalFormat("00.00");
    resultado = base * altura;

    System.out.println("El area del rectángulo es: " + formatoDecimal.format(resultado));
  }

  public void perimetro(){
    var formatoDecimal = new DecimalFormat("00.00");
    resultado = (base * 2) + (altura * 2);

    System.out.println("El perimetro del rectángulo es: " + formatoDecimal.format(resultado));
  }

}
