package ss17_io_binary.bai_tap.product_manager_io_binary;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String nameProduct;
    private String brand;
    private int price;
    private String description;

    public Product() {
    }

    public Product(String code, String nameProduct, String brand, int price,String description) {
        this.code = code;
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
