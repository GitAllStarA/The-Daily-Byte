package DesignPatterns.Creational.Factory;

public class Main_Client {
    public static void main(String[] args) throws Exception {



        // in the below approach the client can call the bank type of account by knowing specific implemtation class names


        BankAccount savings = new SavingsAccount();
        savings.deposite(100000);
        savings.withDrawl(100000);

        BankAccount investment = new InvestmentAccount();
        investment.deposite(20000);
        investment.withDrawl(300000);

        BankAccount checkings = new CheckingAccount();
        checkings.deposite(20000000);
        checkings.withDrawl(2000);

        System.out.println();
        System.out.println("---------------------------------------------------------");
        // in the factory approach you can call ithe implemtations with know actual implementation name ,
        System.out.println("The primary goal of the Factory Design Pattern is to provide a flexible and decoupled way to\n" +
                "create objects, promoting code reusability, maintainability, and scalability.It helps in encapsulating object creation logic and separates\n" +
                "it from the client code.This can contribute to code organization and modularity, which can indirectly contribute to improved security\n" +
                "by promoting clean and manageable code.\n");

        System.out.println("implementing the Factory Design pattern in client code");

        Factory factory = new Factory();
        BankAccount calledType = factory.AccountType("i");
        calledType.withDrawl(10000000);
        calledType.deposite(100);
        System.out.println();
        BankAccount calledType2 = factory.AccountType("s");
        calledType.withDrawl(10000000);
        calledType.deposite(100);
        System.out.println();
        BankAccount calledType3 = factory.AccountType("c");
        calledType.withDrawl(10000000);
        calledType.deposite(100);
    }



}
