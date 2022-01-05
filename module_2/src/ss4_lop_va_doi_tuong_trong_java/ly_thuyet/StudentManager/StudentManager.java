package ss4_lop_va_doi_tuong_trong_java.ly_thuyet.StudentManager;

import java.util.Scanner;

public class StudentManager {
    Student[] studentList = new Student[100];

    public void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birthday: ");
        String birthday = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter school: ");
        String school = scanner.nextLine();
        Student student = new Student(id, name, birthday, address, className, school);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }

    }

    public void displayStudentList() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                System.out.println(studentList[i].toString());
            } else {
                break;
            }
        }
    }
}
