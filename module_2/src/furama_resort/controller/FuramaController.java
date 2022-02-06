package furama_resort.controller;


import furama_resort.services.iml.*;

import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static ContractsServiceImpl contractsService = new ContractsServiceImpl();
    static PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("FURAMA RESORT MANAGER:\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management \n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management \n" +
                    "5.\tPromotion Management\n" +
                    "0.\tExit \n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    managementEmployee();
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
                    managerPromotion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("This option is not available");
            }
        } while (choose != 0);
    }

    private static void managerPromotion() {
        int choose;
        do {
            System.out.println("Facility Management \n " +
                    "1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "0.\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    promotionService.displayCustomerUseService();
                    break;
                case 2:
                    promotionService.displayCustomerGetVoucher();
                    break;
                case 0:
                    break;
            }

        } while (choose != 0);

    }

    private static void managementBooking() {
        int choose;
        do {
            System.out.println("Booking Management \n" +
                    "1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new contracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "0.\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.displayBookingList();
                    break;
                case 3:
                    contractsService.createContracts();
                    break;
                case 4:
                    contractsService.displayContracts();
                    break;
                case 5:
                    contractsService.displayContracts();
                    System.out.println("Enter contract's number you want edit: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    contractsService.editContracts(number);
                    break;
                case 0:
                    break;
            }

        } while (choose != 0);

    }

    private static void managementFacility() {
        int choose;
        do {
            System.out.println("Facility Management \n" +
                    "1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "0\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    facilityService.displayFacility();
                    break;
                case 2:
                    facilityService.addFacility();
                    break;
                case 3:
                    facilityService.displayFacilityMaintenance();
                    break;
                case 0:
                    break;
            }

        } while (choose != 0);

    }

    private static void managementCustomer() {
        int choose;
        do {
            System.out.println("Customer Management\n" +
                    "1\tDisplay list customer\n" +
                    "2\tAdd new customer\n" +
                    "3\tEdit customer\n" +
                    "0\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customerService.displayCustomer();
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    customerService.editCustomer();
                    break;
                case 0:
                    break;
            }

        } while (choose != 0);


    }

    private static void managementEmployee() {
        int choose;
        do {
            System.out.println("Employee Management\n" +
                    "1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "0\tReturn main menu\n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    employeeService.displayEmployee();
                    break;
                case 2:
                    employeeService.addEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 0:
                    break;
            }
        } while (choose != 0);
    }
}
