package c008_oop.AccessExercises;

public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.setName(name);
    this.setAge(age);
  }


  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

}
