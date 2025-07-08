package c008_oop.AccessExercises;

import java.util.SimpleTimeZone;

public class User {
  private String username;
  private String password;

  public User(String username, String password) {
    this.setUsername(username);
    this.setPassword(password);
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void checkPassword(String inputPassword) {
    if (getPassword().equals(inputPassword)){
      System.out.println("Las contraseña coinciden");
      System.out.println("Bienvenido: " + getUsername());
    }else {
      System.out.println("Las contraseñas no coincide.");
    }
  }

  private String getPassword() {
    return password;
  }

  private String getUsername(){
    return username;
  }
}
