package DesignPatterns.Creational.FactoryShape;

import java.util.ArrayList;

public class Shapes {


}

class Square implements Shape {


    @Override
    public float area(int... x) {
        System.out.println("shape Square");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int val : x) {
            arrayList.add(val);
        }
        return arrayList.get(0)*arrayList.get(1);
    }
}

class Circle implements Shape {


    @Override
    public float area(int... x) {
        System.out.println("shape Circle");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int val : x) {
            arrayList.add(val);
        }

        return (float) (Math.PI * arrayList.get(0));
    }
}


class Triangle implements Shape {

    @Override
    public float area(int... x) {
        System.out.println("shape Triangle");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int val : x) {
            arrayList.add(val);
        }
        int height = arrayList.get(0);
        int base = arrayList.get(1);


        return base*height / 2;
    }



}
class UndefinedShape implements Shape {


    @Override
    public float area(int... x) {

        System.out.println("shape not found");

        return -1;
    }

}