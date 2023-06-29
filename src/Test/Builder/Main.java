package Test.Builder;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.Builder("Black","V6 Sports","Automatic").setDownPayment(10000).setPaymentMonths(72).setModel("XSE").build();
        System.out.println(car.toString());
        Car car2 = new Car.Builder("","","").setDownPayment(0).setModel("").build();
        System.out.println(car2.toString());


        Car car3 = new Car.Builder("","","").setDownPayment(0).setModel("sport").build();
        System.out.println(car3.toString());
    }
}
