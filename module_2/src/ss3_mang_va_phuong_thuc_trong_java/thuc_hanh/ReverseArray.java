package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(" Enter a size: ");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + " :");
            array[i] = input.nextInt();
        }
        System.out.printf("%-20s%s", "Element in array: ", "");
        for (int k : array) {
            System.out.print(k + "\t");
        }
        for (int j = 0; j < array.length/2; j++) {
            int temp =array[j];
            array[j]= array[size-1-j];
            array[size-1-j]=temp;
        }
        System.out.printf("\n%-20s%s","Reverse array: ","");
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}
