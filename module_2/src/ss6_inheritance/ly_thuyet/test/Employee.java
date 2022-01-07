package ss6_inheritance.ly_thuyet.test;

public class Employee extends Person{
    public Employee() {
        this("Employee overloading its tasks");
        System.out.println("Employee performing its tasks!");
    }

    public Employee(String s) {
        System.out.println(s);
    }
}
