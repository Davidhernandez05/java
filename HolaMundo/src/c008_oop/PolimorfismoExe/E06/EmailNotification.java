package c008_oop.PolimorfismoExe.E06;

public class EmailNotification extends Notification {


  @Override
  public void sendNotification(Object n) {
    if (emailVerification(n)) {
      System.out.println("Se envío el mensaje a: " + n);
    }else {
      System.out.println("El email ingresado no es valido.");
    }
  }

  private boolean emailVerification(Object n) {

    String email = String.valueOf(n);
    if (email.contains("@")) {
      return true;
    }
    else {
      return false;
    }
  }
}
