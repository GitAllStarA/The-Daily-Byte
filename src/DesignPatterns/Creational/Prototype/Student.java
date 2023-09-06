package DesignPatterns.Creational.Prototype;

public class Student implements Prototype{
    String name;
    int id;
    int age;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;


    }

    @Override
    public Prototype clone() {
        return new Student(name,id,age);
    }
}
