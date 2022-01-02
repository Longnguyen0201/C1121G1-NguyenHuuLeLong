package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TheNumberOfStudentsPassingTheExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Enter a size: ");
            size = input.nextInt();
            if (size > 30) {
                System.out.println("Size should not exceed 30");
            }

        } while (size > 30);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print(" Enter mark for student " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }
        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print(" The number of students passing the exam is " + count);
    }


}
