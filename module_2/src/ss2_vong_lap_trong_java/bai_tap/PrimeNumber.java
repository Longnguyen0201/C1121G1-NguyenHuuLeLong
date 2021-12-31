package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        int number;
        System.out.println("Enter number of primes: ");
        Scanner input = new Scanner(System.in);
        number = input.nextInt();
        int n = 2;
        while (count < number) {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.print(n + " ");
            }
            n++;
        }
    }
}
