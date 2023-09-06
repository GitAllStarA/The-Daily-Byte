package DesignPatterns.Creational.FactoryShape;

//Abstract factory is Factory of a Factory Design pattern
public class FormFactory {

    public Form returnForm(String s) {
        if (s.equalsIgnoreCase("pointy")){
            return new Pointy();
        }
        if (s.equalsIgnoreCase("nonpointy") || s.equalsIgnoreCase("non pointy")){
            return new NonPointy();
        }
        return new UndefinedForm();
    }
}
