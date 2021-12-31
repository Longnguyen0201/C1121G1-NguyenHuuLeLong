package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter investment amount: ");
        money = scanner.nextDouble();

        System.out.println(" Enter number of month: ");
        month = scanner.nextInt();

        System.out.println(" Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();

        double interestTotal = 0;
        for (int i= 0; i< month; i++ ){
            interestTotal += money* (interestRate/100)/12 * month;
        }
        System.out.println(" Total of intetest: " + interestTotal);
    }
}
