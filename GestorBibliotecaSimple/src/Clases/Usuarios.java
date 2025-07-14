package Clases;

public class Usuarios extends Libros {
  private static int contador = 0;

  private final int id;
  private String name;
  private String email;

  public Usuarios(String name, String email) {
    this.id = ++contador;
    this.setName(name);
    this.setEmail(email);
  }



  public int getId() {  return id;  }
  public String getName() {
    return name;
  }
  public String getEmail() {  return email; }

  public void setEmail(String email) {
    this.email = email;
  }
  public void setName(String name) {
    this.name = name;
  }


}
