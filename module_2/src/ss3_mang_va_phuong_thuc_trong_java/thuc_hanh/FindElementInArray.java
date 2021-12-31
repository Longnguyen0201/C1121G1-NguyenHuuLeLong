package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner input =new Scanner(System.in);
        System.out.println("Enter a name's student: ");
        String inputName= input.nextLine();
        boolean isExist = false;

        for (int i=0; i< students.length; i++){
            if (students[i].equals(inputName)){
                System.out.println("Position of the students in the list "+ inputName+ " is: "+i);
                isExist = true;
                break;
            }
        }
        if (!isExist){
            System.out.println("No found "+ inputName+ "in the list ");
        }
    }
}
