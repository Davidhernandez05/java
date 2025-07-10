package c008_oop.InheritanceExercises;

public class Manager extends Employee {

  String department;

  public Manager(String name, double salary, String department) {
    super(name, salary);
    this.department = department;
  }

  public void data() {
    System.out.println(String.format("El empleado: %s del departamento: %s, tiene un salario de: %.00f", name, department, salary));
  }
}
