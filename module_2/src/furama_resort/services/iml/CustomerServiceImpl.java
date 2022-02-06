package furama_resort.services.iml;

import furama_resort.models.Customer;
import furama_resort.services.ICustomerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    private static String CUSTOMER_FILE = "src/furama_resort/data/customer.csv";
    List<Customer> customerList = readFile(CUSTOMER_FILE);
//    Customer customer1 = new Customer(90, "Hien", "04/09/1996", "female", "209183749", "902816381", "hine@gmail.com", "gold", "DaNang");
//    Customer customer2 = new Customer(91, "Huong", "04/12/1997", "female", "209134549", "943816381", "huong@gmail.com", "Menber", "DaNang");


    public List<Customer> readFile(String filePath) {
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

    public void writeFile(Customer customer, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(customer.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        System.out.println("Enter code of new Customer:");
        customer.setCode(Integer.parseInt(scanner.nextLine()));

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
        writeFile(customer, CUSTOMER_FILE);
        System.out.println("Add new customer successfully.");

    }

    @Override
    public void editCustomer() {
        System.out.println("Enter code of customer you want edit:");
        int codeEdit = Integer.parseInt(scanner.nextLine());
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
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    choose = Integer.parseInt(scanner.nextLine());
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
                writeListCustomer();
            }
        }
    }
}
