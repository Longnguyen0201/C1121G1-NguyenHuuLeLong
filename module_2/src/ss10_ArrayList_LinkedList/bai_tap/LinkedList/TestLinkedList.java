package ss10_ArrayList_LinkedList.bai_tap.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public Student() {
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
        MyLinkedList<Student> myLinkedList =new MyLinkedList<>();
        Student student1= new Student(1,"Long");
        Student student2= new Student(2,"Hieu");
        Student student3= new Student(3,"Khai");
        Student student4= new Student(4,"Huy");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student4);
        myLinkedList.add(2,student3);

        for (int i = 0; i< myLinkedList.size(); i++){
            Student student =(Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }

    }
}
