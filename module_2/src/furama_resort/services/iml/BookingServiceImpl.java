package furama_resort.services.iml;

import furama_resort.models.Booking;
import furama_resort.models.Customer;
import furama_resort.models.Facility;
import furama_resort.services.IBookingService;
import furama_resort.services.IFacilityService;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    Scanner scanner = new Scanner(System.in);

    static final String BOOKING_FILE = "src/furama_resort/data/booking.csv";
    TreeSet<Booking> bookingsList = readFile(BOOKING_FILE);


    //    protected static TreeSet<Booking> bookingTreeSet =new TreeSet<>(new BookingComparator());
//    static {
//        Booking booking = new Booking(10,"02/12/2022","04/12/2022",9,"Room service", "Day");
//        Booking booking1 = new Booking(11,"05/12/2022","07/12/2022",10,"House service", "Day");
//        bookingTreeSet.add(booking);
//        bookingTreeSet.add(booking1);
//    }
    public static TreeSet<Booking> readFile(String filePath) {
        TreeSet<Booking> bookingList = new TreeSet<>(new BookingComparator());
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] booking;
            while ((line = bufferedReader.readLine()) != null) {
                booking = line.split(",");
                bookingList.add(new Booking(booking[0], booking[1], booking[2], Integer.parseInt(booking[3]), booking[4], booking[5]));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public void writeFile(Booking booking, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(booking.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBooking() {
        System.out.println("Enter booking code: ");
        String bookingCode = scanner.nextLine();

        System.out.println("Enter start date: ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end date: ");
        String endDate = scanner.nextLine();

        System.out.println("Enter customer's code:");
        int customerCode = choiceCustomerCode();

        System.out.println("Choice service: ");
        Facility facility = choiceService();
        String nameService = facility.getNameService();

        System.out.println("Enter type service: ");
        String typeService = scanner.nextLine();

        Booking booking = new Booking(bookingCode, startDate, endDate, customerCode, nameService, typeService);
        bookingsList.add(booking);

        writeFile(booking, BOOKING_FILE);
        IFacilityService facilityService = new FacilityServiceImpl();
        facilityService.useFacility(nameService);
    }

    @Override
    public void displayBookingList() {
        bookingsList = readFile(BOOKING_FILE);
        for (Booking book : bookingsList) {
            System.out.println(book);
        }
    }

    public int choiceCustomerCode() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.displayCustomer();
        System.out.println("Choice customer code: ");
        int customerCode = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerService.customerList) {
            if (customerCode == customer.getCode()) {
                return customerCode;
            }
        }
        return 0;
    }

    public Facility choiceService() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.displayFacility();
        System.out.println("Choice facility(by ID)");
        String choiceFacility = scanner.nextLine();
        for (Facility facility : facilityService.villaList.keySet()) {
            if (choiceFacility.equals(facility.getIdFacility())) {
                return facility;
            }
        }
        for (Facility facility : facilityService.houseList.keySet()) {
            if (choiceFacility.equals(facility.getIdFacility())) {
                return facility;
            }
        }
        for (Facility facility : facilityService.roomList.keySet()) {
            if (choiceFacility.equals(facility.getIdFacility())) {
                return facility;
            }
        }
        return null;
    }
}

