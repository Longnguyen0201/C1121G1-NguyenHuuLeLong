package furama_resort.services.iml;

import furama_resort.models.Booking;
import furama_resort.models.Customer;
import furama_resort.models.Facility;
import furama_resort.services.IBookingService;
import furama_resort.services.IFacilityService;
import furama_resort.utils.WriteAndReadToCsv;


import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    Scanner scanner = new Scanner(System.in);

    static final String BOOKING_FILE = "src/furama_resort/data/booking.csv";
    static final String BOOKING_NO_CONTRACT_FILE ="src/furama_resort/data/bookingNoContract.csv";
    Set<Booking> bookingSet = WriteAndReadToCsv.readFileBookingToCsv(BOOKING_FILE);
    Set<Booking> bookingsNoContracts = WriteAndReadToCsv.readFileBookingToCsv(BOOKING_NO_CONTRACT_FILE);


    public Set <Booking> sendBooking(){
        return  bookingsNoContracts;
    }

    @Override
    public void addBooking() {
        System.out.println("Enter booking code: ");
        String bookingCode = scanner.nextLine();

        System.out.println("Enter start date: ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end date: ");
        String endDate = scanner.nextLine();


        int customerCode = choiceCustomerCode();


        Facility facility = choiceService();
        String nameService = facility.getNameService();

        System.out.println("Enter type service: ");
        String typeService = scanner.nextLine();

        Booking booking = new Booking(bookingCode, startDate, endDate, customerCode, nameService, typeService);
        bookingSet.add(booking);

        WriteAndReadToCsv.writeFileBookingToCSv(booking,BOOKING_FILE);
        WriteAndReadToCsv.writeFileBookingToCSv(booking,BOOKING_NO_CONTRACT_FILE);
        IFacilityService facilityService = new FacilityServiceImpl();
        facilityService.useFacility(nameService);
    }
    @Override
    public void displayBookingList() {

        for (Booking book : bookingSet) {
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

