package ss10_ArrayList_LinkedList.bai_tap.ArrayList;


public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id,String name) {
            this.name = name;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student student1 =new Student(1,"Long");
        Student student2 =new Student(2,"Khoa");
        Student student3 =new Student(3,"Tam");
        Student student4 =new Student(4,"Tuan");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(1, student4);

        for (int i = 0 ; i < studentMyList.size(); i++){
            Student student = (Student) studentMyList.elements[i];
            System.out.print("ID: "+student.getId());
            System.out.print(" Name: "+ student.getName()+"\n");
        }

        System.out.println(studentMyList.get(2).getName());
        System.out.println(studentMyList.indexOf(student3));

        MyList<Student> newStudentMyList = new MyList<>();
        newStudentMyList= studentMyList.clone();
        newStudentMyList.remove(0);
        for (int i = 0 ; i < newStudentMyList.size(); i++){

            System.out.print(" Name: "+ newStudentMyList.get(i).getName()+"\n");
        }


    }
}
