package ss14_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class InsertionSort {
    static  int[] array = {3,5,2,6,1,9,4,12,8,7};
    public static void main(String[] args) {
        System.out.println("Your array:");
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));


    }
    public static void insertionSort(int[] arr){
        int pos;
        int x;
        for (int i = 0; i <arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]){
                arr[pos] = arr[pos-1];
                pos--;
            }
                arr[pos]=x;

        }
    }
}
