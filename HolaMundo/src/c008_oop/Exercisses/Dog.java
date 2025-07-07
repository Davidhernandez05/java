package c008_oop.Exercisses;

public class Dog {
  public String nombre; //Si no se pone pública la variable no permite el acceso desde fuera del repo.
  int edad;
  String raza;

  public void bark(){
    System.out.println(String.format("El perro %s ladra.", nombre));
  }
}
