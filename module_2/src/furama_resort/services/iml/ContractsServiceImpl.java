package furama_resort.services.iml;

import furama_resort.models.Booking;
import furama_resort.models.Contracts;
import furama_resort.services.IContractsService;
import furama_resort.utils.WriteAndReadToCsv;

import java.io.*;
import java.util.*;

public class ContractsServiceImpl implements IContractsService {
    static Scanner scanner = new Scanner(System.in);
    private final String CONTRACTS_LIST = "src/furama_resort/data/contracts.csv";
    Queue<Contracts> contractList = WriteAndReadToCsv.readFileContractToCsv(CONTRACTS_LIST);



    @Override
    public void createContracts() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        List<Booking> bookingContract = new ArrayList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for (Booking booking : bookingSet) {
            if (!booking.getNameService().contains("Room")) {
                bookingQueue.add(booking);
                Booking booking1 = bookingQueue.poll();
                System.out.println("Doing contract with booking \n" + booking);
                Contracts contracts = new Contracts();
                System.out.println("Enter contract number: ");
                contracts.setContractNumber(Integer.parseInt(scanner.nextLine()));
                contracts.setBookingCode(booking.getBookingNumber());
                System.out.println("Enter deposit: ");
                contracts.setDeposit(Double.parseDouble(scanner.nextLine()));
                System.out.println("Enter total payment: ");
                contracts.setTotalPayment(Double.parseDouble(scanner.nextLine()));
                contracts.setCustomerCode(booking.getCustomerCode());
                contractList.add(contracts);
                WriteAndReadToCsv.writeFileContractTocCsv(contracts, CONTRACTS_LIST);
            }
        }
        writeFileBooking(convertListToString(bookingContract),BookingServiceImpl.BOOKING_NO_CONTRACT_FILE,false);
    }
//        Set<Booking> bookingList = bookingService.bookingsNoContracts;
//        List<Booking> bookingContract = new ArrayList<>();
//        Queue<Booking> newBookingList = new LinkedList<>();
//        newBookingList.addAll(bookingList);
//        while (newBookingList.size() > 0) {
//            if (newBookingList.peek().getTypeService().contains("Room")) {
//                bookingContract.add(newBookingList.peek());
//                newBookingList.poll();
//            } else {
//                Booking booking = newBookingList.peek();
//                System.out.println("Doing contract with booking \n" + booking);
//                Contracts contracts = new Contracts();
//
//                System.out.println("Enter contract number: ");
//                contracts.setContractNumber(Integer.parseInt(scanner.nextLine()));
//                contracts.setBookingCode(booking.getBookingNumber());
//                System.out.println("Enter deposit: ");
//                contracts.setDeposit(Double.parseDouble(scanner.nextLine()));
//                System.out.println("Enter total payment: ");
//                contracts.setTotalPayment(Double.parseDouble(scanner.nextLine()));
//                contracts.setCustomerCode(booking.getCustomerCode());
//
//                contractList.add(contracts);
//
//                writeFile(contracts, CONTRACTS_LIST);
////               bookingService.writeFile();
//                newBookingList.poll();
//            }
//        }
//        writeFileBooking(convertListToString(bookingContract),BookingServiceImpl.BOOKING_FILE,false);


    private List<String> convertListToString(List<Booking> bookingList) {
        List<String> stringList = new ArrayList<>();
        System.out.println("đã tới");
        for (Booking booking : bookingList) {
            stringList.add(booking.writeToFile());
        }
        return stringList;
    }

    private void writeFileBooking(List<String> stringList, String filePath, boolean append) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String booking : stringList) {
                bufferedWriter.write(booking);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayContracts() {
        System.out.println("Contracts List: ");
        for (Contracts contracts : contractList) {
            System.out.println(contracts);
        }
    }

    @Override
    public void editContracts(int number) {
        contractList = WriteAndReadToCsv.readFileContractToCsv(CONTRACTS_LIST);
        for (Contracts contracts : contractList) {
            if (number == contracts.getContractNumber()) {
                int choice;
                do {
                    System.out.println(contracts);
                    System.out.println("1. Edit contract deposit\n" +
                            "2. Edit total payment of contract\n" +
                            "0. Exit");
                    System.out.println("Your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new deposit: ");
                            contracts.setDeposit(Double.parseDouble(scanner.nextLine()));
                            writeListContractToFile();
                            System.out.println("Edit successfully");
                            break;
                        case 2:
                            contracts.setTotalPayment(Double.parseDouble(scanner.nextLine()));
                            writeListContractToFile();
                            System.out.println("Edit successfully");
                            break;
                        case 0:
                            break;
                    }
                } while (choice != 0);
            }
        }
    }

    public void writeListContractToFile() {
        try {
            File file = new File(CONTRACTS_LIST);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contracts contract : contractList) {
                bufferedWriter.write(contract.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
