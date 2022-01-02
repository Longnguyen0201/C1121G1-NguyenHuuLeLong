package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class SumTheNumberDiagonalInMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array length : ");
        int size = input.nextInt();
        int[][] array = new int[size][size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Enter element " + i + "-" + j + " : ");
                array[i][j] = input.nextInt();
            }
            System.out.println(Arrays.toString(array[i]));
        }
        for (int k =0; k< size;k++){
            sum+=array[k][k];
        }
        System.out.println("Sum the number diagonal in matrix: " + sum);
    }
}
