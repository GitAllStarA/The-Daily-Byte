package Vehicles;

import java.util.*;
import java.util.stream.IntStream;

sealed class Vehicles permits Car, Trucks {

    protected int wheels;
    protected String engine;

    protected String type;
    public void create(String type, int wheels, String engine) {
        System.out.println(type);
        System.out.println(wheels+" "+engine);
    }


}

final class Car extends Vehicles {
    @Override
    public void create(String type, int wheels, String engine) {
        super.create(type, wheels, engine);
    }


    static boolean statsWithB(String s, String w) {
        return s.startsWith(w);
    }

    static String appenderStar(String s) {
        return "*"+s;
    }

    public void retunmeStirng(){
        List<String> list = Arrays.asList("a","b","bb","cvb");

         List<String> x = list
                            .stream()
                            .filter((s)-> Car.statsWithB(s,"b"))
                            .map(Car::appenderStar)
                            .toList();

        System.out.println(x);


        IntStream intStream = List.of(1,2,3,4,5,6).stream().mapToInt(n -> n);

        // here stream2 are consider same as intStream, once any one of the stream is opened cannot be used again
        IntStream stream2 = intStream;

        /*OptionalInt min = intStream.min();
        System.out.println(min);*/
        OptionalInt max = stream2.max();
        System.out.println(max);

        //System.out.println(intStream.min());
        //System.out.println(stream2.max());


    }


}



final class Trucks extends Vehicles {
    @Override
    public void create(String type, int wheels, String engine) {
        super.create(type, wheels, engine);
    }
}
