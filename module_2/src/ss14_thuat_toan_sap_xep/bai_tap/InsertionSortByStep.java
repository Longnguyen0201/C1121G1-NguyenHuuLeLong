package ss14_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = Integer.parseInt( scanner.nextLine());
        int[] array = new int[size];
        System.out.println("Enter value:");

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Your array: ");
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Beging sort: ");
        insertionSort(array);
    }

    public static void insertionSort(int[] arr) {
        int pos;
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]) {
                System.out.println("Swap "+ arr[pos] +" with "+ arr[pos-1]);
                arr[pos] =arr[pos -1];
                pos--;
                System.out.println( Arrays.toString(arr));
            }
            arr[pos] = x;
            System.out.println("insert " + x);
            System.out.println("loop "+ i+" : " + Arrays.toString(arr));
        }
    }
}
