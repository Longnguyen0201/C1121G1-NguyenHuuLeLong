package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println(" Enter the number of array: ");
        size = input.nextInt();
        int[] array = new int[size];
        int min;
        for (int i = 0; i < size; i++) {
            System.out.print(" Enter element " + i + " is:");
            array[i] = input.nextInt();
        }
        System.out.println(" Array: " + Arrays.toString(array));
        min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i]< min){
                min = array [i];
            }
        }
        System.out.println(" Min element is: "+ min);
    }
}
