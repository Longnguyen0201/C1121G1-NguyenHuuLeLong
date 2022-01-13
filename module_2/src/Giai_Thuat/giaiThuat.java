package Giai_Thuat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class giaiThuat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(" Enter a " + i);
            a[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                b[i] = a[i];
            } else {
                b[i] = b[i - 1] + a[i];
            }
        }
        System.out.println(Arrays.toString(b));
    }


}
