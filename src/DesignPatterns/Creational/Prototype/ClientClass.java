package DesignPatterns.Creational.Prototype;

public class ClientClass {
    public static void main(String[] args) {
        //client created student
        Student s = new Student("Zola",1,4);

        //with help of prototype interface implemented in student we can cloneS object of student also cloneS private methods / variables
        Student cloneS = (Student) s.clone();
        System.out.println("clone name "+cloneS.name +", id "+cloneS.id +", age "+cloneS.age);

        //same can be done for various classes

        Employee e = new Employee("Zollo","Youtube", "1223");
        Employee cloneEmp = (Employee) e.clone();
        System.out.println("cloneS emp "+cloneEmp.name+", cloneS dept "+cloneEmp.dept+", cloneS id "+cloneEmp.id);
    }
}
