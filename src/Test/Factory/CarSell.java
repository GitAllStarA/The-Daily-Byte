package Test.Factory;

public class CarSell implements CarSale{

    @Override
    public void carCost() {
        System.out.println("your car maket value $"+31000);
    }

    @Override
    public void carSaleTye(String carSale) {
        System.out.println("car sale type "+carSale);
    }
}
