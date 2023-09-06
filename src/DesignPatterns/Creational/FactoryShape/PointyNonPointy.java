package DesignPatterns.Creational.FactoryShape;

import java.util.ArrayList;
import java.util.Arrays;

public class PointyNonPointy {

}

class Pointy implements Form{


    @Override
    public Shape shapeForm(String s) {
        if (s.equalsIgnoreCase("square")){
            System.out.println("square");
            return new Square();
        }
        if (s.equalsIgnoreCase("rectangle")) {
            System.out.println("rectangle");
            return new Square();
        }
        else {
            System.out.println("undefined shape");
            return new UndefinedShape();
        }
    }
}

class NonPointy implements Form{
    @Override
    public Shape shapeForm(String s) {
        if (s.equalsIgnoreCase("circle")){
            System.out.println("circle");
            return new Circle();
        }
        if (s.equalsIgnoreCase("sphere")) {
            System.out.println("sphere");
            return new Circle();
        }
        else {
            System.out.println("undefined shape");
            return new UndefinedShape();
        }
    }
}

class UndefinedForm implements Form{
    @Override
    public Shape shapeForm(String s) {
        System.out.println("undefined shape");
        return new UndefinedShape();
    }
}
