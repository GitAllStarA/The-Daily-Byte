package DesignPatterns.Factory;

public class InvestmentAccount implements BankAccount{
    @Override
    public void deposite(int amount) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        StackTraceElement stackTraceElement = stackTraceElements[1];

        System.out.println(stackTraceElement+" you have deposited $"+amount);

    }

    @Override
    public void withDrawl(int amount) {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[1] + "you have withdrawn $"+amount);

    }
}
