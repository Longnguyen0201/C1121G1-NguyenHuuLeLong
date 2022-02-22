package giai_de.C10.model;

public abstract class Products {
    private int idProduct;
    private String codeProduct;
    private String nameProduct;
    private double price;
    private int quantity;
    private String manufacturer;

    public Products() {

    }

    public Products(int idProduct, String codeProduct, String nameProduct, double price, int quantity, String manufacturer) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Products{" +
                "IdProduct=" + idProduct +
                ", CodeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturer='" + manufacturer;
    }

    public String writeToFileCsv() {
        return idProduct + "," + codeProduct + "," + nameProduct + "," + price + "," + quantity + "," + manufacturer;
    }
}
