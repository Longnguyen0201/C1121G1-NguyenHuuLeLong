package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementInArray {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 8};
        System.out.println(Arrays.toString(array));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter element value to delete: ");
        int elementValue = input.nextInt();
        int indexDel = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementValue) {
                indexDel = i;
            }
        }
        for (int j = indexDel; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        array[array.length - 1] = 0;
        System.out.println(Arrays.toString(array));
    }
}
