package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit.");
        System.out.println("Enter your chose: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println(" Enter hight: ");
                int hight = input.nextInt();
                System.out.println(" Enter width: ");
                int width = input.nextInt();

                for (int i = 0; i < hight; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("*");
                    }
                    System.out.println("*");
                }
                break;
            case 2:
                System.out.println("1. top-left");
                System.out.println("2. top-right");
                System.out.println("3. botton-left");
                System.out.println("4. botton-right");
                System.out.println("0. Exit");
                System.out.println("Enter your chose triangle");
                int choice1 = input.nextInt();

                System.out.println(" Enter hight: ");
                int hight1 = input.nextInt();
                switch (choice1) {
                    case 1:
                        for (int i = hight1; i >= 1; i--) {
                            for (int j = 1; j <= i; j++) {
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        break;
                    case 2:
                        for (int i = 0; i < hight1; i++) {
                            for (int j = 0; j < i; j++) {
                                System.out.print(" ");
                            }
                            for (int k = hight1 - i; k > 0; k--) {
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        break;
                    case 3:
                        for (int i = 1; i <= hight1; i++) {
                            for (int j = 1; j < i; j++) {
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        break;
                    case 4:
                        for (int i = 0; i < hight1; i++) {
                            for (int j = hight1 - i; j > 0; j--) {
                                System.out.print(" ");
                            }
                            for (int k = 0; k < i + 1; k++) {
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        break;
                    case 0:
                        System.exit(0);
                }
                break;
            case 3:
                System.out.println(" Enter hight: ");
                int hight2 = input.nextInt();
                for (int i = 1; i <= hight2; i++) {
                    for (int j = hight2; j > i; j--) {
                        System.out.print(" ");
                    }
                    for (int k = 1; k <= (i * 2 - 1); k++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                System.exit(4);
        }
    }
}
