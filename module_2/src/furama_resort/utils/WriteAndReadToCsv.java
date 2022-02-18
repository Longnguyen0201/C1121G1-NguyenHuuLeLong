package furama_resort.utils;

import furama_resort.models.*;
import furama_resort.services.iml.BookingComparator;

import java.io.*;
import java.util.*;

public class WriteAndReadToCsv {
    public static final String VILLA_FILE = "src/furama_resort/data/villa.csv";
    public static final String HOUSE_FILE = "src/furama_resort/data/house.csv";
    public static final String ROOM_FILE = "src/furama_resort/data/room.csv";

    public static ArrayList<Employee> readFileEmployeeToCsv(String filePath) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] employee;
            while ((line = bufferedReader.readLine()) != null) {
                employee = line.split(",");
                employeeList.add(new Employee(Integer.parseInt(employee[0]), employee[1], employee[2], employee[3], employee[4], employee[5], employee[6], employee[7], employee[8], Integer.parseInt(employee[9])));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return employeeList;
    }

    public static void writeFileEmployeeToCsv(Employee employee, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(employee.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFileCustomerToCsv(String filePath) {
        List<Customer> customerList = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] customer;
            while ((line = bufferedReader.readLine()) != null) {
                customer = line.split(",");
                customerList.add(new Customer(Integer.parseInt(customer[0]), customer[1], customer[2], customer[3], customer[4], customer[5], customer[6], customer[7], customer[8]));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return customerList;
    }

    public static void writeFileCustomerToCsv(Customer customer, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(customer.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<Facility, Integer> readFileFacilityToCsv(String filePath) {
        LinkedHashMap<Facility, Integer> list = new LinkedHashMap<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] facility;
            while ((line = bufferedReader.readLine()) != null) {
                facility = line.split(",");
                if (filePath.equals(VILLA_FILE)) {
                    Villa newVilla = new Villa(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6], Integer.parseInt(facility[7]), Integer.parseInt(facility[8]));
                    list.put(newVilla, newVilla.getValue());
                } else if (filePath.equals(HOUSE_FILE)) {
                    House newHouse = new House(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6], Integer.parseInt(facility[7]));
                    list.put(newHouse, newHouse.getValue());
                } else {
                    Room newRoom = new Room(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6]);
                    list.put(newRoom, newRoom.getValue());
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
        return list;
    }

    public static void writeFileFacilityToCsv(Facility facility, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(facility.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
    }

    public static TreeSet<Booking> readFileBookingToCsv(String filePath) {
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

    public static void writeFileBookingToCSv(Booking booking, String filePath) {
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

    public static Queue<Contracts> readFileContractToCsv(String filePath) {
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

    public static void writeFileContractTocCsv(Contracts contracts, String filePath) {
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


}
