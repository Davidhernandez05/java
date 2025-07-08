package c008_oop.AccessExercises;

public class BankAccount {
  private double balance;

  public BankAccount(double balance) {
    this.setBalance(balance);
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
    if (amount > 0){
      balance += amount;
      setBalance(balance);
    }else {
      System.out.println("El valor ingresado la depositar no es valido.");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0) {
      balance -= amount;
      setBalance(balance);
    }else {
      System.out.println("El valor ingresado para retirar no es valido.");
    }
  }
}
