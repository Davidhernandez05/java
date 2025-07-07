package c008_oop.Exercisses;

import java.text.DecimalFormat;

public class Worker {

  public String name;
  public double salary;
  public double bono;

  public Worker(String name, double salary){
    this.name = name;
    this.salary = salary;
  }

  public void showSalary(){
    var formato = new DecimalFormat(".00");
    salary += bono;
    System.out.println(name + "Tiene un salario de: " + formato.format(salary));
  }
}
