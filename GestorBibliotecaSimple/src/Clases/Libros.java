package Clases;

public class Libros {
  private static int contador = 0;

  private final int id;
  private String title;
  private String author;
  private int year;
  private boolean disponibilidad;

  public Libros(String title, String author, int year, boolean disponibilidad) {
    this.id = ++contador;
    this.setTitle(title);
    this.setAuthor(author);
    this.setYear(year);
    this.setDisponibilidad(disponibilidad);
  }

  public Libros() {
    id = 0;
  }

  //Getters
  public String getTitle() {
    return title;
  }
  public int getYear() {
    return year;
  }
  public String getAuthor() {
    return author;
  }
  public int getId() {  return id;  }

  public boolean isDisponibilidad() { return disponibilidad;  }

  //Setters
  public void setAuthor(String author) {
    this.author = author;
  }
  public void setTitle(String title) {this.title = title;}
  public void setYear(int year) {
    this.year = year;
  }

  public void setDisponibilidad(boolean disponibilidad) { this.disponibilidad = disponibilidad; }
}

