package furama_resort.services.iml;

import furama_resort.models.Employee;
import furama_resort.models.Person;
import furama_resort.services.IEmployeeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    private static String EMPLOYEE_FILE ="src/furama_resort/data/employee.csv";
    ArrayList<Employee> employeeList = this.readFile(EMPLOYEE_FILE);
//    static {
//        Employee employee = new Employee(01, "Long", "02/02/1999", "Male", "201719675", "901834199", "Long@gmail.com", "University", "dev1", 1500);
//        Employee employee2 = new Employee(02, "Khoa", "02/01/1999", "Male", "2017329675", "902334199", "Khoa@gmail.com", "University", "dev1", 2500);
//        employeeList.add(employee);
//        employeeList.add(employee2);
//    }




    @Override
    public void displayEmployee() {
        System.out.println("Employee list: ");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    @Override
    public void addEmployee() {

        try {
            System.out.println("Enter code of new Employee (Ex: 123,231,..): ");
            int codeEmployee = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter name of new Employee:");
            String name = scanner.nextLine();
            System.out.println("Enter birthday of new Employee:");
            String birthday = scanner.nextLine();
            System.out.println("Enter gender of new Employee:");
            String gender = scanner.nextLine();
            System.out.println("Enter ID of new Employee: ");
            String id = scanner.nextLine();
            System.out.println("Enter Phone number of new Employee: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter email of new Employee:");
            String email = scanner.nextLine();
            System.out.println("Enter academic level of new Employee:");
            String level = scanner.nextLine();
            System.out.println("Enter position of new Employee:");
            String position = scanner.nextLine();
            System.out.println("Enter salary number of new Employee (Ex: 10000000): ");
            int salary = Integer.parseInt(scanner.nextLine());
            Employee newEmployee = new Employee(codeEmployee, name, birthday, gender, id, phoneNumber, email, level, position, salary);
            employeeList.add(newEmployee);
            this.writeFile(newEmployee,EMPLOYEE_FILE);
            System.out.println("Add new employee successfully.");
        }catch (Exception e){
            System.out.println("wrong format input ");
        }

    }

    @Override
    public void editEmployee() {
        System.out.println("Enter code of Employee you want edit ");
        int codeEdit = Integer.parseInt(scanner.nextLine());
        for (Employee employee: employeeList) {
            if (employee.getCode() == codeEdit) {
                int choose;
               do  {
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
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    choose = Integer.parseInt(scanner.nextLine());
                    switch (choose){
                        case 1:
                            System.out.println("Enter new name of Employee:");
                            employee.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter new birthday of Employee:");
                            employee.setBirthday(scanner.nextLine());
                            break;
                        case 3:
                            System.out.println("Enter new gender of Employee:");
                            employee.setGender(scanner.nextLine());
                            break;
                        case 4:
                            System.out.println("Enter new ID of Employee:");
                            employee.setIdNumber(scanner.nextLine());
                            break;
                        case 5:
                            System.out.println("Enter new phone number of Employee:");
                            employee.setPhoneNumber(scanner.nextLine());
                            break;
                        case 6:
                            System.out.println("Enter new email of Employee:");
                            employee.setEmail(scanner.nextLine());
                            break;
                        case 7:
                            System.out.println("Enter new level of Employee:");
                            employee.setLevel(scanner.nextLine());
                            break;
                        case 8:
                            System.out.println("Enter new position of Employee:");
                            employee.setPosition(scanner.nextLine());
                            break;
                        case 9:
                            try {
                                System.out.println("Enter new salary of Employee:");
                                employee.setSalary(Integer.parseInt(scanner.nextLine()));
                            }catch (Exception e){
                                System.out.println("Wrong format input");
                            }
                            break;
                        case 0:
                            break;
                    }
                }while (choose != 0);
                System.out.println("Edit employee successfully");
                writeListEmployeeFile();
            }
        }
    }
    public void writeListEmployeeFile() {
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
    public  ArrayList<Employee> readFile(String filePath) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";
            String[] employee;
            while ((line= bufferedReader.readLine())!= null){
                employee = line.split(",");
                employeeList.add(new Employee(Integer.parseInt(employee[0]),employee[1],employee[2],employee[3],employee[4],employee[5],employee[6],employee[7],employee[8],Integer.parseInt(employee[9])));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return employeeList;
    }

    private void writeFile (Employee employee,String filePath){
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(employee.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
