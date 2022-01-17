package FuramaResort.controller;


import java.util.Scanner;

public class FuramaController {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("FURAMA RESORT MANAGER:\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management \n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management \n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit \n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    managementEmloyee();
                    break;
                case 2:
                    managementCustomer();
                    break;
                case 3:
                    managementFacility();
                    break;
                case 4:
                    managementBooking();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("This option is not available");
            }
        } while (choose != 6);
    }



    private static void managementBooking() {
        int choose;
        do {
            System.out.println("Booking Management " +
                    "1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:
                case 6:
            }

        } while (choose != 4);

    }

    private static void managementFacility() {
        int choose;
        do {
            System.out.println("Facility Management " +
                    "1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tEdit facility\n" +
                    "4\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:

                case 2:

                case 3:

                case 4:
            }

        } while (choose != 4);

    }

    private static void managementCustomer() {
        int choose;
        do {
            System.out.println("Customer Management " +
                    "1\tDisplay list customer\n" +
                    "2\tAdd new customer\n" +
                    "3\tEdit customer\n" +
                    "4\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:

                case 2:

                case 3:

                case 4:
            }

        } while (choose != 4);



    }

    private static void managementEmloyee() {
        int choose;
        do {
            System.out.println("Employee Management " +
                    "1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
             switch (choose){
                 case 1:

                 case 2:

                 case 3:

                 case 4:
             }

        } while (choose != 4);

    }
}
