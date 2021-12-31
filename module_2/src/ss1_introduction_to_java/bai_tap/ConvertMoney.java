package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        double vnd ;
        double usd;

        Scanner scanner= new Scanner(System.in);
        System.out.println(" Enter money (USD): ");
        usd = scanner.nextDouble();
         vnd = usd*23000;

        System.out.println("Value VND to "+ usd +" USD là: "+ vnd);
    }
}
