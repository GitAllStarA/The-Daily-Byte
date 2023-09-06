package DesignPatterns.Creational.FactoryShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClientClass {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        var c = shapeFactory.getSharpe("circle");
        System.out.println(c.area(44));

        var t = shapeFactory.getSharpe("triangle");
        System.out.println(t.area(4,5));

        var s = shapeFactory.getSharpe("square");
        System.out.println(s.area(4,4));

        System.out.println("_____________________________");

        FormFactory formFactory = new FormFactory();
        var fFP = formFactory.returnForm("pointy");
        var circle = fFP.shapeForm("circle");
        var square = fFP.shapeForm("square");

        var fFNP = formFactory.returnForm("non pointy");
        var circle2 = fFNP.shapeForm("circle");
        var square2 = fFNP.shapeForm("square");

    }
}
