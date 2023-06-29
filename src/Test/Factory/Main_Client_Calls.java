package Test.Factory;

public class Main_Client_Calls {
    public static void main(String[] args) throws Exception {
        CarSaleFactory carSaleFactory = new CarSaleFactory();
        carSaleFactory.carSaleType("car buy");
        System.out.println();
        carSaleFactory.carSaleType("car lease");
        System.out.println();
        carSaleFactory.carSaleType("car rental");
        System.out.println();
        carSaleFactory.carSaleType("car sell");
    }
}
