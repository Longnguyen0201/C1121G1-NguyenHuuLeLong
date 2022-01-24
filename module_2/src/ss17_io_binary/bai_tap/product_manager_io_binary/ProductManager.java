package ss17_io_binary.bai_tap.product_manager_io_binary;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private final String PATH_FILE = "src/ss17_io_binary/bai_tap/product_manager_io_binary/product_list_file";
    Scanner scanner = new Scanner(System.in);
    List<Product> products = readDataFromFlie (PATH_FILE);

    public void add(Product product) {
        products.add(product);
        writeToFile(PATH_FILE, products);
    }

    public void add() {
        System.out.println("Enter product's code: ");
        String code = scanner.nextLine();
        System.out.println("Enter product's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product's brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter product's price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product's description: ");
        String description = scanner.nextLine();
        Product product = new Product(code, name, brand, price,description);
        products.add(product);
        writeToFile(PATH_FILE, products);
    }

    public void showList() {
        System.out.println("Product list:");
        List<Product> productDataFromFile = readDataFromFlie(PATH_FILE);
        for (Product products : productDataFromFile) {
            System.out.println(products);
        }
    }

    public void searchProduct ( String info){
        List<Product> productList = readDataFromFlie(PATH_FILE);
        System.out.println("Search product " + info);
        int count = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (info.equals(productList.get(i).getCode())
                    ||info.equals(productList.get(i).getNameProduct())
                    ||info.equals(productList.get(i).getBrand())){
                System.out.println(productList.get(i));
                count++;
            }
        }
        if (count == 0 ){
            System.out.println(" No matching products found ");
        }
    }


    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFlie(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (EOFException e ) {
            System.out.println("Empty file");
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
