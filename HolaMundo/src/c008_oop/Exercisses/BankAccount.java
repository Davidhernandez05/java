package c008_oop.Exercisses;

public class BankAccount {

  final private String idAccount;
  public int balance;
  int saldo;
  private int age;


  public BankAccount(String idAccount, int balance, int age){
    this.idAccount = idAccount;
    this.balance = balance;
    this.setAge(age);
  }

  public void deposit() {
    saldo += balance;
    System.out.println("Su saldo actual es de: " + saldo);
  }

  // Getter: -> nos permite visualizar los datos privados, no nos permite modificarlos.
  public String getShowIdAccount() {
    return idAccount;
  }

  // Setters:
  public void setAge(int age) {
    if (age >= 12){
      this.age = age;
    }else {
      System.out.println("Edad no valida para hacer esta transacción.");
    }
  }

  public int getAge() {
    return age;
  }
}
