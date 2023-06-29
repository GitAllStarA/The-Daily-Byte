package Test.Factory;

public class CarRental implements CarSale{
    @Override
    public void carCost() {
        System.out.println("per day car rental cost $"+30);
    }

    @Override
    public void carSaleTye(String carSale) {
        System.out.println("car sale type "+carSale);
    }
}
