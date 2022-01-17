package ss12_Collection.thuc_hanh.comparable_and_comparator;

import java.util.*;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() >o2.getAge()){
            return 1;
        }else if (o1.getAge()==o2.getAge()){
            return 0;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );
        List< Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        Collections.sort(lists);
        for (Student students: lists){
            System.out.println(students.toString());
        }

        AgeComparator ageComparator =new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println(" So sánh theo tuổi");
        for (Student students: lists){
            System.out.println(students.toString());
        }
    }
}
