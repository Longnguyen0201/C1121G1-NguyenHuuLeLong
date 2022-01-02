package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double celsius;
        double fahrenheit;
        int choice;

        do {
            System.out.println(" Menu");
            System.out.println(" 1. Fahrenheit to Celsius");
            System.out.println(" 2. Celsius to Fahrenheit");
            System.out.println(" 0. Exit");
            System.out.println(" Enter your choice: ");
            choice = input.nextInt();
            switch ( choice){
                case 1:
                    System.out.println(" Enter fahrenheit: ");
                    fahrenheit = input.nextDouble();
                    System.out.println("Fahrenheit to Celsius: "+ fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println(" Enter celsius: ");
                    celsius = input.nextDouble();
                    System.out.println("celsius to Fahrenheit: "+ celsiusToFehrenheit (celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        }while (choice != 0);
    }
    public static double celsiusToFehrenheit(double celsius){
        double fahrenheit = (9.0 / 5) * celsius +32;
        return  fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) *( fahrenheit-32);
        return  celsius;
    }
}
