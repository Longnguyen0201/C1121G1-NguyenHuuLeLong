package ss4_lop_va_doi_tuong_trong_java.ly_thuyet.StudentManager;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        StudentManager student = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int chose;
        boolean flag = true;
        do {
            System.out.println("1. Add\n" +
                    "2.\tDisplay\n" +
                    "3.\tEdit\n" +
                    "4.\tDelete\n" +
                    "5.\tSearch\n" +
                    "6.\tExit\n");
            System.out.println("Enter chose: ");
            chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Add");
                    student.addNewStudent();
                case 2:
                    System.out.println("Display");
                    student.displayStudentList();
                case 3:
                    System.out.println("Edit");
                case 4:
                    System.out.println("Delete");
                case 5:
                    System.out.println("Search");
                case 6:
                    flag = false;
            }
        } while (flag);
    }
}
