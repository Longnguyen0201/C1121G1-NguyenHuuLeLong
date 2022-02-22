package giai_de.C10.services.impl;

import giai_de.C10.model.ExportProduct;
import giai_de.C10.model.ImportProduct;
import giai_de.C10.model.Products;
import giai_de.C10.services.IProductService;
import giai_de.C10.utils.ReadAndWriteFileCSV;
import giai_de.C10.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements IProductService {
    static final String PRODUCTS_FILE = "src/giai_de/C10/data/Products.csv";


    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("ADD PRODUCT\n" +
                    "1. Import Product. \n" +
                    "2. Export product \n" +
                    "3. Return menu\n");
            while (true) {
                try {
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format input, Please re-enter: ");
                }
            }
            switch (choice) {
                case 1:
                    productType(1);
                    break;
                case 2:
                    productType(2);
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    @Override
    public void displayProduct() {
        List<Products> productsList = ReadAndWriteFileCSV.readFileToCSV(PRODUCTS_FILE);
        for (Products products : productsList) {
            System.out.println(products);
        }
    }

    @Override
    public void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        List<Products> productsList = ReadAndWriteFileCSV.readFileToCSV(PRODUCTS_FILE);
        while (true) {
            displayProduct();
            System.out.println("Enter product code or product name your want search: ");
            String productSearch = scanner.nextLine();

            if (productSearch.trim().equals("")) {
                System.out.println("Wrong input, please re-enter:");
            } else {
                boolean flag = false;
                for (Products products : productsList) {
                    if (products.getCodeProduct().toLowerCase().contains(productSearch.toLowerCase()) ||
                            products.getNameProduct().toLowerCase().contains(productSearch.toLowerCase())) {
                        System.out.println(products);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Not found product in product list");
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        List<Products> productsList = ReadAndWriteFileCSV.readFileToCSV(PRODUCTS_FILE);
        System.out.println("Enter product code you want delete: ");
        String deleteCode = scanner.nextLine();
        if (deleteCode.trim().equals("")) {
            System.out.println("Wrong input, Please re-enter: ");
        } else {
            boolean flag = false;
            for (Products products : productsList) {
                if (products.getCodeProduct().equals(deleteCode)) {
                    int choice = 0;
                    do {
                        System.out.println("you want delete: " + products);
                        System.out.println("1. Yes\n" +
                                "2. No \n");
                        while (true) {
                            try {
                                System.out.println("Enter your choice: ");
                                choice = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format input, Please re-enter: ");
                            }
                            switch (choice) {
                                case 1:
                                    productsList.remove(products);
                                    ReadAndWriteFileCSV.writeListProductFile(productsList, PRODUCTS_FILE);
                                    displayProduct();
                                    System.out.println("Delete successful");
                                    break;
                                case 2:
                                    System.out.println("You canceled");
                                    break;
                                default:
                                    System.out.println("please enter (1 or 2 )");
                            }
                        }
                    } while (choice != 2);
                } else {
                    System.out.println("Don't found product");
                }
            }
        }
    }

    private void productType(int choice) {
        List<Products> productsList = new ArrayList<>();
        int id = 1;
        if (!productsList.isEmpty()) {
            id = productsList.get(productsList.size() - 1).getIdProduct() + 1;
        }

        String productCode = Validation.resultStringValidation("Enter products code: ");


        String name = Validation.resultStringValidation("Enter products name: ");

        double price = Validation.resultDoubleValidation("Enter products price: ");

        int quantity = Validation.resultIntValidation("Enter product quantity: ");

        String manufacturer = Validation.resultStringValidation("Enter product manufacturer: ");


        if (choice == 1) {

            double importPrice = Validation.resultDoubleValidation("Enter import price: ");

            String province = Validation.resultStringValidation("Enter import province: ");

            double tax = Validation.resultDoubleValidation("Enter import Tax: ");

            Products newImportProduct = new ImportProduct(id, productCode, name, price, quantity, manufacturer, importPrice, province, tax);
            productsList.add(newImportProduct);

            ReadAndWriteFileCSV.writeFileProductsToCsv(newImportProduct, PRODUCTS_FILE);

        } else if (choice == 2) {

            double exportPrice = Validation.resultDoubleValidation("Enter Export price: ");

            String nation = Validation.resultStringValidation("Enter import nation:");

            Products newExportProduct = new ExportProduct(id, productCode, name, price, quantity, manufacturer, exportPrice, nation);
            productsList.add(newExportProduct);
            ReadAndWriteFileCSV.writeFileProductsToCsv(newExportProduct, PRODUCTS_FILE);
        }
    }


}
