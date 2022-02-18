package furama_resort.services.iml;

import furama_resort.models.Employee;
import furama_resort.services.IEmployeeService;
import furama_resort.utils.RegexData;
import furama_resort.utils.WriteAndReadToCsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    public static final String REGEX_BIRTHDAY = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String EMPLOYEE_FILE = "src/furama_resort/data/employee.csv";


    @Override
    public void displayEmployee() {
        List<Employee> employeeList = WriteAndReadToCsv.readFileEmployeeToCsv(EMPLOYEE_FILE);
        System.out.println("Employee list: ");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void addEmployee() {
        ArrayList<Employee> employeeList = WriteAndReadToCsv.readFileEmployeeToCsv(EMPLOYEE_FILE);
        int codeEmployee = 0;
        while (true) {
            try {
                System.out.println("Enter code of new Employee (Ex: 123,231,..): ");
                codeEmployee = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Wrong format input, please re-enter");
            }
        }
        System.out.println("Enter name of new Employee:");
        String name = scanner.nextLine();
        System.out.println("Enter birthday of new Employee:");
        String birthday = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
        System.out.println("Enter gender of new Employee:");
        String gender = scanner.nextLine();
        System.out.println("Enter ID of new Employee: ");
        String id = scanner.nextLine();
        System.out.println("Enter Phone number of new Employee: ");
        String phone = scanner.nextLine();
        System.out.println("Enter email of new Employee:");
        String email = RegexData.regex(scanner.nextLine(), REGEX_EMAIL, "Ex: abc@gmail.com");
        System.out.println("Enter academic level of new Employee:");
        String level = scanner.nextLine();
        System.out.println("Enter position of new Employee:");
        String position = scanner.nextLine();
        int salary = 0;
        while (true) {
            try {
                System.out.println("Enter salary number of new Employee (Ex: 10000000): ");
                salary = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format input");
            }
        }
        Employee employee = new Employee(codeEmployee, name, birthday, gender, id, phone, email, level, position, salary);
        employeeList.add(employee);
        WriteAndReadToCsv.writeFileEmployeeToCsv(employee, EMPLOYEE_FILE);
        System.out.println("Add new employee successfully.");

    }

    @Override
    public void editEmployee() {
        ArrayList<Employee> employeeList = WriteAndReadToCsv.readFileEmployeeToCsv(EMPLOYEE_FILE);
        displayEmployee();

        int codeEdit = 0;
        while (true) {
            try {
                System.out.println("Enter code of Employee you want edit ");
                codeEdit = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format input, Please re-enter: ");
            }
        }
        for (Employee employee : employeeList) {
            if (employee.getCode() == codeEdit) {
                int choose = 0;
                do {
                    System.out.println(
                            "1.Name\n" +
                                    "2.Birthday\n" +
                                    "3.Gender\n" +
                                    "4.ID number\n" +
                                    "5.Phone number\n" +
                                    "6.Email\n" +
                                    "7.Level\n" +
                                    "8.Position\n" +
                                    "9.Salary\n" +
                                    "0.Exit\n");
                    while (true) {
                        try {
                            System.out.println("Choose section you want to edit: ");
                            choose = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.err.println("Wrong format input, Please re-enter : ");
                        }
                    }
                    switch (choose) {
                        case 1:
                            System.out.println("Enter new name of Employee:");
                            employee.setName(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 2:
                            System.out.println("Enter new birthday of Employee:");
                            employee.setBirthday(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 3:
                            System.out.println("Enter new gender of Employee:");
                            employee.setGender(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 4:
                            System.out.println("Enter new ID of Employee:");
                            employee.setIdNumber(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 5:
                            System.out.println("Enter new phone number of Employee:");
                            employee.setPhoneNumber(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 6:
                            System.out.println("Enter new email of Employee:");
                            employee.setEmail(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 7:
                            System.out.println("Enter new level of Employee:");
                            employee.setLevel(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 8:
                            System.out.println("Enter new position of Employee:");
                            employee.setPosition(scanner.nextLine());
                            System.out.println("Edit employee successfully");
                            break;
                        case 9:
                            while (true) {
                                try {
                                    System.out.println("Enter new salary of Employee:");
                                    employee.setSalary(Integer.parseInt(scanner.nextLine()));
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Wrong format input, Please re-enter");
                                }
                            }
                            break;
                        case 0:
                            break;
                    }
                } while (choose != 0);
                writeListEmployeeFile();
            }
        }
    }

    public void writeListEmployeeFile() {
        ArrayList<Employee> employeeList = WriteAndReadToCsv.readFileEmployeeToCsv(EMPLOYEE_FILE);
        try {
            File file = new File(EMPLOYEE_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(employee.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
