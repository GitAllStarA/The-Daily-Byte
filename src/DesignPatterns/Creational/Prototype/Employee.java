package DesignPatterns.Creational.Prototype;

public class Employee implements Prototype{
    String name;
    String dept;
    String id;


    public Employee(String name, String dept, String id) {
        this.name = name;
        this.dept = dept;
        this.id = id;
    }


    @Override
    public Prototype clone() {
        return new Employee(name,dept,id);
    }
}
