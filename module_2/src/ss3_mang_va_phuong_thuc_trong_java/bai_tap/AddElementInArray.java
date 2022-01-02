package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(array));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter element value to add: ");
        int elementValue = input.nextInt();
        System.out.println("Enter position index: ");
        int index = input.nextInt();

        if (index <= -1 || index >= array.length - 1) {
            System.out.println("Do not add element in array");
        }
        for (int i = array.length-1 ; i > index; i--) {

            array[i]= array[i-1];


        }
        array[index] = elementValue;

        System.out.println(Arrays.toString(array));
    }
}
