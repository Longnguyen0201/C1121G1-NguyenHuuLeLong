package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumElementInAColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array length : ");
        int rows = input.nextInt();
        System.out.print("Enter element array length: ");
        int column = input.nextInt();
        int[][] arr = new int[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter element " + i + "-" + j + " : ");
                arr[i][j] = input.nextInt();
            }
        }
        System.out.print(" Enter tolal column: ");
        int columnNumber = input.nextInt();
        int sum = 0;

        if (columnNumber > column) {
            System.out.println(" Number of columns cannot be greater than " + column);
        } else {
            for (int i =0;i< rows;i++) {
                sum += arr[i][columnNumber];
            }
        }
        System.out.print("The sum of column " + columnNumber + " is: " + sum);
    }
}
