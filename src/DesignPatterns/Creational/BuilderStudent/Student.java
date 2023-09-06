package DesignPatterns.Creational.BuilderStudent;

public class Student {

    String firstName;
    String lastName;
    int id;
    String address;
    String gender;


    public Student(StudentBuilder studentBuilder) {
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.id = studentBuilder.id;
        this.address = studentBuilder.address;
        this.gender = studentBuilder.gender;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}


class StudentBuilder {
    String firstName;
    String lastName;
    int id;
    String address;
    String gender;




    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}



