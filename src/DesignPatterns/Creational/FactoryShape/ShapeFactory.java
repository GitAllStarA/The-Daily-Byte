package DesignPatterns.Creational.FactoryShape;


// Factory design pattern mainly deals with object creation where creating of object
// can be done at single point of class example below class
public class ShapeFactory {

    public Shape getSharpe(String shape) {
        if (shape.equalsIgnoreCase("circle")){

            return new Circle();
        }
        if (shape.equalsIgnoreCase("rectangle") || shape.equalsIgnoreCase("square")){

            return new Square();
        }
        if (shape.equalsIgnoreCase("Triangle")){

            return new Triangle();
        }

        return new UndefinedShape();
    }
}
