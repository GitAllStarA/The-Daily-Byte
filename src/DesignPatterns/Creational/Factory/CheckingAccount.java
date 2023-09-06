package DesignPatterns.Creational.Factory;

public class CheckingAccount implements BankAccount {

    @Override
    public void deposite(int amount) {
        System.out.println("you have deposited $"+amount);
    }

    @Override
    public void withDrawl(int amount) {
        System.out.println("you have withdrawn $"+amount);
    }
}
