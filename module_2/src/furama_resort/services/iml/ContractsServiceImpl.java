package furama_resort.services.iml;

import furama_resort.models.Booking;
import furama_resort.models.Contracts;
import furama_resort.models.Facility;
import furama_resort.services.IContractsService;

import java.io.*;
import java.util.*;

public class ContractsServiceImpl implements IContractsService {
    Scanner scanner = new Scanner(System.in);
    private final String CONTRACTS_LIST = "src/furama_resort/data/contracts.csv";
    Queue<Contracts> contractList = readFile(CONTRACTS_LIST);
    BookingServiceImpl bookingService = new BookingServiceImpl();

    public Queue<Contracts> readFile(String filePath) {
        Queue<Contracts> list = new ArrayDeque<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] contracts;
            while ((line = bufferedReader.readLine()) != null) {
                contracts = line.split(",");
                list.add(new Contracts(Integer.parseInt(contracts[0]), contracts[1], Double.parseDouble(contracts[2]), Double.parseDouble(contracts[3]), Integer.parseInt(contracts[4])));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void writeFile(Contracts contracts, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(contracts.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void createContracts() {
        Set<Booking> bookingList = bookingService.bookingsList;
        List<Booking> bookingContract = new ArrayList<>();
        Queue<Booking> newBookingList = new ArrayDeque<>();
        newBookingList.addAll(bookingList);
        while (newBookingList.size() > 0) {
            if (newBookingList.peek().getTypeService().equals("Room")) {
                bookingContract.add(newBookingList.peek());
                newBookingList.poll();
            } else {
                Booking booking = newBookingList.peek();
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

                writeFile(contracts, CONTRACTS_LIST);
//               bookingService.writeFile();
                newBookingList.poll();
            }
        }
        writeFileBooking(convertListToString(bookingContract),BookingServiceImpl.BOOKING_FILE,false);
    }

    private List<String> convertListToString(List<Booking> bookingList){
        List<String> stringList = new ArrayList<>();
        System.out.println("đã tới");
        for (Booking booking: bookingList){
            stringList.add(booking.writeToFile());
        }
        return stringList;
    }
    private void writeFileBooking (List<String> stringList, String filePath, boolean append){
        try {
            File file =new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file,append);
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
        contractList = readFile(CONTRACTS_LIST);
        for (Contracts contracts: contractList) {
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
                            break;
                        case 2:
                            contracts.setTotalPayment(Double.parseDouble(scanner.nextLine()));
                            writeListContractToFile();
                            break;
                        case 0:
                            break;
                    }
                } while (choice != 0);
                System.out.println("Edit successfully");
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
