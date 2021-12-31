package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 2) {
            System.out.println(number + " is not a prime");
        } else {
            int i = 2;
            boolean flag = true;
            while (i < number) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag) {
                System.out.println(number + " is a prime");
            } else {
                System.out.println(number + " is not a prime");
            }
        }
    }
}
