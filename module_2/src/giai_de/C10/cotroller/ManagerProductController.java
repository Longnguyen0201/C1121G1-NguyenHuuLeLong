package giai_de.C10.cotroller;

import giai_de.C10.services.impl.ProductServiceImpl;

import java.util.Scanner;

public class ManagerProductController {
    static ProductServiceImpl productService = new ProductServiceImpl();

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("PRODUCT MANAGER \n" +
                    "1. Add product. \n" +
                    "2. Delete product \n" +
                    "3. Display product list\n" +
                    "4. Search product\n" +
                    "5. Exit");
            while (true) {
                try {
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format input, Please re-enter: ");
                }
            }
            switch (choice){
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.deleteProduct();
                    break;
                case 3:
                    productService.displayProduct();
                    break;
                case 4:
                    productService.searchProduct();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("This option is not available");
            }

        }while (choice != 5);
    }
}
