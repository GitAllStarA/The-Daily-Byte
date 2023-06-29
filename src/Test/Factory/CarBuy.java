package Test.Factory;

public class CarBuy implements CarSale{
    @Override
    public void carCost() {
        System.out.println("Amount $32000");
    }

    @Override
    public void carSaleTye(String carSale) {
        System.out.println("car sale type : "+carSale);
    }
}
