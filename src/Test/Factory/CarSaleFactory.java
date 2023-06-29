package Test.Factory;

public class CarSaleFactory {

    public CarSale carSaleType(String saleType) throws Exception {
        if (saleType.equalsIgnoreCase("car buy") || saleType.equalsIgnoreCase("cb")){
            CarSale carSale = new CarBuy();

            carSale.carSaleTye(saleType);
            carSale.carCost();

            return carSale;
        }
        if (saleType.equalsIgnoreCase("car lease") || saleType.equalsIgnoreCase("cl")){
            CarSale carSale = new CarLease();

            carSale.carSaleTye(saleType);
            carSale.carCost();
            return carSale;
        }
        if (saleType.equalsIgnoreCase("car rental") || saleType.equalsIgnoreCase("cr")){
            CarSale carSale = new CarRental();

            carSale.carSaleTye(saleType);
            carSale.carCost();
            return carSale;
        }
        if (saleType.equalsIgnoreCase("car sell") || saleType.equalsIgnoreCase("cs")){
            CarSale carSale = new CarSell();
            carSale.carSaleTye(saleType);
            carSale.carCost();
            return carSale;
        }
        else {
            throw new Exception("invalid data entered please enter car buy or car sell or car lease or car rental");
        }

    }
}
