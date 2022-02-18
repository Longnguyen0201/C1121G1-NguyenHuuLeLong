package furama_resort.services.iml;

import furama_resort.models.Customer;
import furama_resort.models.Person;
import furama_resort.services.ICustomerService;
import furama_resort.utils.WriteAndReadToCsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    private static final String CUSTOMER_FILE = "src/furama_resort/data/customer.csv";
    List<Customer> customerList = WriteAndReadToCsv.readFileCustomerToCsv(CUSTOMER_FILE);


    @Override
    public void displayCustomer() {
        System.out.println(" Customer List");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomer() {
        Customer customer = new Customer();
        while (true) {
            try {
                System.out.println("Enter code of new Customer:");
                customer.setCode(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.err.println("Wrong format input");
            }
        }
        System.out.println("Enter name of new customer: ");
        customer.setName(scanner.nextLine());

        System.out.println("Enter birthday of new customer:");
        customer.setBirthday(scanner.nextLine());

        System.out.println("Enter gender of new customer");
        customer.setGender(scanner.nextLine());

        System.out.println("Enter ID number of new customer:");
        customer.setIdNumber(scanner.nextLine());

        System.out.println("Enter phone number of new customer:");
        customer.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter email of customer: ");
        customer.setEmail(scanner.nextLine());

        System.out.println("Enter type of customer: ");
        customer.setTypeCustomer(scanner.nextLine());

        System.out.println("Enter address of new customer: ");
        customer.setAddress(scanner.nextLine());

//            customerList.add(customer);
        WriteAndReadToCsv.writeFileCustomerToCsv(customer, CUSTOMER_FILE);
        System.out.println("Add new customer successfully.");

    }

    @Override
    public void editCustomer() {
        int codeEdit =0 ;
        while (true) {
            try {
                System.out.println("Enter code of customer you want edit:");
                 codeEdit = Integer.parseInt(scanner.nextLine());
                 break;
            }catch (NumberFormatException e){
                System.err.println("Wrong format number, please re-enter");
            }
        }
        for (Customer customer : customerList) {
            if (codeEdit == customer.getCode()) {
                int choose;
                do {
                    System.out.println("1.Name of customer\n" +
                            "2.Birthday of customer\n" +
                            "3.Gender of customer\n" +
                            "4.ID number of customer\n" +
                            "5.Phone number of customer\n" +
                            "6.Email of customer\n" +
                            "7.Type of customer\n" +
                            "8.Address of customer\n" +
                            "0.Exit\n");
                    while (true){
                        try{
                            System.out.println("Choose section you want to edit:");
                            choose = Integer.parseInt(scanner.nextLine());
                            break;
                        }catch (NumberFormatException e){
                            System.out.println();
                        }
                    }

                    switch (choose) {
                        case 1:
                            System.out.println("Enter new name of customer: ");
                            customer.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter new birthday of customer: ");
                            customer.setBirthday(scanner.nextLine());
                            break;
                        case 3:
                            System.out.println("Enter new gender of customer: ");
                            customer.setGender(scanner.nextLine());
                            break;
                        case 4:
                            System.out.println("Enter new ID number of customer: ");
                            customer.setIdNumber(scanner.nextLine());
                            break;
                        case 5:
                            System.out.println("Enter new phone number of customer: ");
                            customer.setPhoneNumber(scanner.nextLine());
                            break;
                        case 6:
                            System.out.println("Enter new email of customer: ");
                            customer.setEmail(scanner.nextLine());
                            break;
                        case 7:
                            System.out.println("Enter new type of customer: ");
                            customer.setTypeCustomer(scanner.nextLine());
                            break;
                        case 8:
                            System.out.println("Enter new address of customer: ");
                            customer.setAddress(scanner.nextLine());
                            break;
                        case 0:
                    }

                } while (choose != 0);
                System.out.println("Edit custom successfully");
            }
            writeListCustomer();
        }
    }
    private void writeListCustomer() {
        try {
            File file = new File(CUSTOMER_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
