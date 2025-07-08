package c008_oop.AccessExercises;

public class Student {
  private int grade;

  public Student (int grade) {
    this.setGrade(grade);
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public boolean isPassed() {
    if (grade > 100) {
      System.out.println("Dato ingresado no valido.");

    } else if (grade >= 60 && grade <= 100) {
      return true;

    }
    return false;
  }
}
