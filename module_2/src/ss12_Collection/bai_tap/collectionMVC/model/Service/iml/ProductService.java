package ss12_Collection.bai_tap.collectionMVC.model.Service.iml;

import ss12_Collection.bai_tap.collectionMVC.model.Service.IProductService;
import ss12_Collection.bai_tap.collectionMVC.model.Service.iml.SortPriceIncrease;
import ss12_Collection.bai_tap.collectionMVC.model.Service.iml.SortPriceReduce;
import ss12_Collection.bai_tap.collectionMVC.model.model.ProductModel;

import java.util.*;

public class ProductService implements IProductService {
    private static List<ProductModel> product = new ArrayList<>();

    static {
        ProductModel productModel = new ProductModel(1, "Iphone 11", 1000);
        ProductModel productModel1 = new ProductModel(2, "NOKIA", 300);
        ProductModel productModel2 = new ProductModel(3, "Samsum", 700);
        product.add(productModel);
        product.add(productModel1);
        product.add(productModel2);
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void addProduct() {

        System.out.print("Enter ID of product: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter product's name: ");
        String name = input.nextLine();
        System.out.print(" Enter price of product: ");
        double price = Double.parseDouble(input.nextLine());

        ProductModel productModel1 = new ProductModel(id, name, price);
        product.add(productModel1);
    }

    @Override
    public void displayProduct() {
        for (ProductModel productService : product) {
            System.out.println(productService);
        }
    }

    @Override
    public void removeProduct() {
        System.out.print(" Input id want to delete ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getId() == id) {
                product.remove(i);
            }
        }
    }

    @Override
    public void editProduct() {
        System.out.print(" Input id want to edit ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getId() == id) {
                System.out.println(" Enter the content you want to edit\n" +
                        "1. Name\n" +
                        "2. Price\n" +
                        "3. Exit\n");
                System.out.print("Your choose: ");
                int choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1:
                        System.out.print("Enter new Id: ");
                        String newName = input.nextLine();
                        product.get(i).setName(newName);
                        break;
                    case 2:
                        System.out.print("Enter new Id: ");
                        double newPrice = Double.parseDouble(input.nextLine());
                        product.get(i).setPrice(newPrice);
                        break;
                    case 3:
                        break;
                }
            }

        }

    }

    @Override
    public void sortPriceProduct() {
        System.out.println("Price change: \n" +
                "1. Increase\n" +
                "2. Reduce\n");
        System.out.println("Yours choose");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                SortPriceIncrease sortPriceIncrease = new SortPriceIncrease();
                Collections.sort(product,sortPriceIncrease);
                break;
            case 2:
                SortPriceReduce sortPriceIncreaseReduce = new SortPriceReduce();
                Collections.sort(product, sortPriceIncreaseReduce);
                break;
        }


    }

    @Override
    public void searchProduct() {
        System.out.print("Enter name's product you want search: ");
        String name = input.nextLine();
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                System.out.println(product.get(i).toString());
                break;
            }
            System.out.println(name +" not available ");
        }
    }
}



