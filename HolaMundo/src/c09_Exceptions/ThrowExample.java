package c09_Exceptions;

public class ThrowExample  {

  public void checkAge(int age) throws IllegalAccessException { // Aquí le decimos que cuidado que si falla va a lanzar un error
    if (age < 18) {
      throw new IllegalAccessException("Error: Tienes que ser mayor de edad para acceder.");
    }else {
      System.out.println("Tienes acceso.");
    }
  }

  public void checkScore(int score) throws CustomException {
     if (score < 0 || score > 100) {
        throw new CustomException("La puntuación debe estar entre 0 y 100."); //Mensaje que va a tener el error (throw).
     }else {
       System.out.println("Puntuación valida: " + score);
     }
  }
}
