package Giai_Thuat;

import org.jetbrains.annotations.NotNull;

public class Test {
    public void bubbleSort(int @NotNull [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--)
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
        }
        System.out.println(array);
    }

    public  void main(int[] args) {
        args = new int[]{-1, 150, 190, 170, -1, -1, 160, 180};
        bubbleSort(args);
    }

}

