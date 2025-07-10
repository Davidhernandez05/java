package c008_oop.PolimorfismoExe.E06;

public class Notification {

  public String send() {
    return "Se enviara un mensaje...";
  }

  public void sendNotification(Object n){
    System.out.println("Enviando una notificación...");
  }
}
