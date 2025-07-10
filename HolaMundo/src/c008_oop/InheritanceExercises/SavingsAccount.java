package c008_oop.InheritanceExercises;

import c008_oop.AccessExercises.BankAccount;

public class SavingsAccount extends BankAccount {

  public SavingsAccount(double balance) {
    super(balance);
  }

  public void addInterest() {
    System.out.println("Se agregaran intereses a tu cuenta.");
  }
}
