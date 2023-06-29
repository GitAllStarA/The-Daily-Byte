package Test.Factory;

public class CarLease implements CarSale{

    @Override
    public void carCost() {
        System.out.println("for $10000 miles for year $"+600+" per month");
        System.out.println("for $12000 miles for year $"+625+" per month");
        System.out.println("for $15000 miles for year $"+650+" per month");
    }

    @Override
    public void carSaleTye(String carSale) {
        System.out.println("car sale type "+carSale);
    }
}
