package ss5_access_modifer.bai_tap.ClassInJava;

public class TestStudent {
    public static void main(String[] args) {
        Student student =new Student();
        student.setName("Long");
        student.setClasses("C1121G1");
        System.out.println(student.getName());
        System.out.println(student.getClasses());

    }

}
