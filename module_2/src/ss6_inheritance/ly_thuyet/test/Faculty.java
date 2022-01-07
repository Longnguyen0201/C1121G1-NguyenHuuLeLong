package ss6_inheritance.ly_thuyet.test;

public class Faculty extends Employee{
    public Faculty() {
        System.out.println("Faculty performing its tasks");
    }

    public static void main(String[] args) {
        new Faculty();
    }
}
