package c008_oop.AccessExercises;

public class Employee {
  private double salary;

  public Employee(double salary){
    this.setSalary(salary);
  }

  public void setSalary(double salary) {
    this.salary = salary;
    System.out.println("Tu salario quedo en: " + salary);
  }

  public void getSalary(){
    System.out.println("Salario actual: " + salary);
  }

  public void raiseSalary(double percent){
    if (percent >= 0) {
      System.out.println("Tu salario quedo en: " + increase(percent));
    }else {
      System.out.println("Porcentaje de aumento salarial no valido.");
    }
  }

  private double increase(double percent) {
    double percentage;
    double salaryFinal;
    if (percent > 0) {
      percentage = salary * (percent / 100);
      salaryFinal = salary + percentage;

      return salaryFinal;
    }
    System.out.println("No se genero un aumento salarial para este empleado.");
    return salary;
  }
}
