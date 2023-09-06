package DesignPatterns.Creational.Factory;

public class Factory {

    public BankAccount AccountType(String accountType) throws Exception {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[1]);



        if (accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("s")) {
            
            return new SavingsAccount();
        } else if (accountType.equalsIgnoreCase("investment") || accountType.equalsIgnoreCase("i")) {
            return new InvestmentAccount();
        } else if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("c")) {
            return new CheckingAccount();
        }
        else {
            throw new Exception("invalid entry");
        }
    }

}
