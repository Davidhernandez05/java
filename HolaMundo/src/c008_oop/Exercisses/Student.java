package c008_oop.Exercisses;

public class Student {
  public String name;
  public int score;

  public Student(String name, int score){
    this.name = name;
    this.score = score;
  }

  public String approve() {
    String estudiante;
    if (score >= 60){
       estudiante = String.format("El estudiante: %s, aprobó: %b", name, true);
      return estudiante;
    }
    estudiante = String.format("El estudiante: %s, aprobó: %b", name, false);
    return estudiante;
  }
}
