package ss12_Collection.bai_tap.CollectionMVC.Model.Service.iml;

import ss12_Collection.bai_tap.CollectionMVC.Model.Model.ProductModel;

import java.util.*;

public class ProductService implements IProductService {
    private static List<ProductModel> product = new ArrayList<>();

    static {
        ProductModel productModel =new ProductModel(1,"Iphone 11",1000 );
        ProductModel productModel1 =new ProductModel(2,"NOKIA",300 );
        ProductModel productModel2 =new ProductModel(3,"Samsum",700 );
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

        ProductModel productModel1 = new ProductModel(id,name,price);
        product.add(productModel1);
    }

    @Override
    public void displayProduct() {
        for (ProductModel productService: product){
            System.out.println(productService);
        }
    }

    @Override
    public void removeProduct() {
        System.out.print(" Input id want to delete ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < product.size(); i++) {
            if(product.get(i).getId()==id){
                product.remove(i);
            }
        }
    }

    @Override
    public void editProduct() {
        System.out.print(" Input id want to edit ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getId() == id){
                System.out.println(" Enter the content you want to edit\n"+
                        "1. ID\n"+
                        "2. Name\n"+
                        "3. Price\n"+
                        "4. Exit\n");
                System.out.print("Your choose: ");
                int choose =Integer.parseInt(input.nextLine());
                switch (choose){
                    case 1:
                        System.out.print("Enter new Id: ");
                        int newId = Integer.parseInt(input.nextLine());
                        product.get(i).setId(newId);
                        break;
                    case 2:
                        System.out.print("Enter new Id: ");
                        String newName =input.nextLine();
                        product.get(i).setName(newName);
                        break;
                    case 3:
                        System.out.print("Enter new Id: ");
                        double newPrice = Double.parseDouble(input.nextLine());
                        product.get(i).setPrice(newPrice);
                        break;
                    case 4:
                        break;
                }
            }

        }

    }

    @Override
    public void sortPriceProduct() {
        System.out.println("Price change: \n"+
                "1. Increase\n"+
                "2. Reduce\n");
        System.out.println("Yours choose");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose){
            case 1:
                Collection.




        }


    }



