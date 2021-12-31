package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class GreateCommonFactor {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a: ");
        a = scanner.nextInt();
        System.out.println("Enter b: ");
        b = scanner.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("NO greatest common factor");
        }
        while (a != b) {
            if (a > b) {
                a = a - b;
            }else{
                b = b-a;
            }
        }
        System.out.printf("Greatest common factor: %d ", a);

    }
}
