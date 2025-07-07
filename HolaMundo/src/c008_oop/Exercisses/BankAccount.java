package c008_oop.Exercisses;

public class BankAccount {

  public int balance;
  int saldo;

  public BankAccount(int balance){
    this.balance = balance;
  }

  public void deposit() {
    saldo += balance;
    System.out.println("Su saldo actual es de: " + saldo);
  }
}
