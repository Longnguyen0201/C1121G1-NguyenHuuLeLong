package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = new int[3];
        int[] array2 = new int[3];
        int[] array3 = new int[6];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array1.length; i++) {
            System.out.print("Enter element " + (i + 1) + " for array1: ");
            array1[i] = input.nextInt();
        }
        for (int j = 0; j < array1.length; j++) {
            System.out.print("Enter element" + (j + 1) + " for array2: ");
            array2[j] = input.nextInt();
        }
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        for (int k = 0; k < array1.length; k++) {
            array3[k]= array1[k];

        }
        for (int k = array3.length-1 ; k<0;k--){

        }
        System.out.println("Array 3: " + Arrays.toString(array3));

    }
}
