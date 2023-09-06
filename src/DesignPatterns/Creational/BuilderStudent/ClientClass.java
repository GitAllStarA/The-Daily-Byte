package DesignPatterns.Creational.BuilderStudent;

public class ClientClass {

    public static void main(String[] args) {

        StudentBuilder sb = new StudentBuilder();
        Student jake = sb.setFirstName("Jake").setLastName("Roruke").setId(1).setAddress("San Francisco").setGender("M").build();
        System.out.println(jake.toString());

    }
}
