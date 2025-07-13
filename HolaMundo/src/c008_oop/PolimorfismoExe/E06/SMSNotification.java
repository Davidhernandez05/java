package c008_oop.PolimorfismoExe.E06;

public class SMSNotification extends Notification{

  @Override
  public void sendNotification(Object n) {
    System.out.println("Se envío un mensaje al numero: " + n);
  }


}
