package Clases;

public class Biblioteca {

  private String userSeparation;
  private String tittleBook;
  private boolean disponibilidad;


  // Constructores:
  public Biblioteca(String userSeparation, String tittleBook, boolean disponibilidad) {
    this.setTittleBook(tittleBook);
    this.setUserSeparation(userSeparation);

  }

  //Getters
  public String getUserSeparation() { return userSeparation; }
  public String getTittleBook() { return tittleBook;  }
  public boolean isDisponibilidad() { return disponibilidad;  }

  //setters
  public void setUserSeparation(String userSeparation) {  this.userSeparation = userSeparation; }
  public void setTittleBook(String tittleBook) {  this.tittleBook = tittleBook;}

  public void setDisponibilidad(boolean disponibilidad) { this.disponibilidad = disponibilidad; }
}
