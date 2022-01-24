package ss17_io_binary.bai_tap.product_manager_io_binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product Manager:\n" +
                "1. Display product list.\n" +
                "2. Add product.\n" +
                "3. Search product.\n" +
                "4. Exit.\n");
        int choice;
        do {
            System.out.print("Your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.showList();
                    break;
                case 2:
                    productManager.add();
                   break;
                case 3:
                    System.out.println("Information you want to find: ");
                    String info = scanner.nextLine();
                    productManager.searchProduct(info);
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }
}
