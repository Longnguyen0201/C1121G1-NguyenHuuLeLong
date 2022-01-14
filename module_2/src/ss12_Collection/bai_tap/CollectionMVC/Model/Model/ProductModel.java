package ss12_Collection.bai_tap.CollectionMVC.Model.Model;

import java.util.Comparator;

public class ProductModel implements Comparable <ProductModel> {
    private int id;
    private String name;
    private double price;

    public ProductModel(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    @Override
    public int compareTo(ProductModel price) {
        return (int) (this.price - price.getPrice());
    }
}
