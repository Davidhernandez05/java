package c008_oop.Exercisses;

public class Book {
  // Atributos del Objeto:
  String tittle;
  String author;

  public Book(String tittle, String author) {
    this.tittle = tittle;
    this.author = author;
  }

  public void dataBook(){
    System.out.println(String.format("Libro: %s, escrito por el autor: %s", tittle, author));
  }
}
