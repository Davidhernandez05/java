package c008_oop.InheritanceExercises;

public class Student extends Person{

  int grade;

  public Student(String name, int age, int grade) {
    super(name, age);
    this.grade = grade;
  }
  public void study(){
    System.out.println(String.format("El estudiante: %s esta en grado: %d, y tiene %d años", name, grade, age));
  }
}
