package Vehicles;

import Vehicles.Car;
import Vehicles.Motorcycles;
import Vehicles.Trucks;

public class V {
    public static void main(String[] args) {
        Car c = new Car();
        c.create("maruti swift",4, "1200cc");

        Trucks t = new Trucks();
        t.create("Ashok Leyland", 10, "6000cc");

        Motorcycles m = new Motorcycles();
      //  m.create("Hero", 2, "125cc");


        c.retunmeStirng();


    }
}