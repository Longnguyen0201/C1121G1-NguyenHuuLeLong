package ss5_access_modifer.thuc_hanh.StaticMethod;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDit";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }
    static void change(){
        college ="CODEGYM";
    }
    void display(){
        System.out.println(rollno+" "+name+" "+college);
    }
}
