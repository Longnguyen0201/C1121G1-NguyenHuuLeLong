package giai_de.C10.model;

public class ImportProduct extends Products{
    private double importPrice;
    private String province;
    private double importTax;

    public ImportProduct() {
    }

    public ImportProduct(int idProduct, String codeProduct, String nameProduct, double price, int quantity, String manufacturer, double importPrice, String province, double importTax) {
        super(idProduct, codeProduct, nameProduct, price, quantity, manufacturer);
        this.importPrice = importPrice;
        this.province = province;
        this.importTax = importTax;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", importPrice=" + importPrice +
                ", province='" + province + '\'' +
                ", importTax=" + importTax +
                "} ";
    }
    public String writeToFileCsv() {
        return super.writeToFileCsv() + ","+importPrice+","+province+","+importTax;
    }
}
