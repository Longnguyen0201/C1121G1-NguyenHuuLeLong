package ss12_Collection.bai_tap.CollectionMVC.Controller;

import ss12_Collection.bai_tap.CollectionMVC.Model.Service.iml.IProductService;
import ss12_Collection.bai_tap.CollectionMVC.Model.Service.iml.ProductService;

import java.util.Scanner;


public class ProductController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductService productService = new ProductService();
        int choose;
        do {

            System.out.println("PRODUCT MANAGER:\n" +
                    "1. Add Product\n" +
                    "2. Edit Product \n" +
                    "3. Remove Product\n" +
                    "4. Display Product \n" +
                    "5. Search Product\n"+
                    "6. Sort Product \n" +
                    "7. Exit \n");
            System.out.print("Enter your choose: ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.editProduct();
                    break;
                case 3:
                    productService.removeProduct();
                    break;
                case 4:
                    productService.displayProduct();
                    break;
                case 5:
                    productService.searchProduct();
                    break;
                case 6:
                    productService.sortPriceProduct();
                case 7:
                    break;
                default:
                    System.out.println("This option is not available");
            }
        } while (choose != 6);
    }
}
