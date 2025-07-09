package c09_Exceptions;

public class Exceptions {
  public static void main(String[] args) throws IllegalAccessException {
    //Manejo de excepciones:

    // Try Catch:
    try {
      //Aquí va el código que potencialmente podría llegar a fallar.
      var result = 10 / 2;
      System.out.println(result);
    }catch (Exception e) {
      //En caso de generarse un error, se ejecutaría el catch
      System.out.println("Se produjo un error: " +  e.getLocalizedMessage());

    }

    // Try con multiples Catch:
    try {
      var result = 10 / 2;
      System.out.println(result);

      String name = "Brais";
      name = null;
      System.out.println("Name:" + name.toUpperCase());

    }catch (ArithmeticException err) {
      System.out.println("Error aritmético: " + err.getLocalizedMessage());

    }catch (NullPointerException err) {
      System.out.println("Error null pointer mítico: " + err.getLocalizedMessage());

    }catch (Exception err) {
      System.out.println("Error no esperado: " + err);
    }

    // finally:
    try {
      var result = 10 / 0;
      System.out.println(result);

    }catch (Exception e) {
      System.out.println("Se produjo un error: " +  e.getLocalizedMessage());

    }finally {
      // Se ejecuta siempre: sea que exista o no un error.
      System.out.println("Se finaliza el try-catch.");
    }

    //throw:
    var throwExample = new ThrowExample();
    try {
      throwExample.checkAge(15);

    }catch (IllegalAccessException err) { // IllegalAccessException -> es un Checked Exception por eso al comienzo se genera un throw.
      System.out.println("Se genero un error de acceso: " + err.getLocalizedMessage());

    }

    //Excepción personalizada:
    var score = new ThrowExample();

    try {
      score.checkScore(101);

    }catch (CustomException err) {
      System.out.println("Error: " + err.getLocalizedMessage());
    }

    System.out.println("FIN.");
  }
}
