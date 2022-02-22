package giai_de.C10.model;

public class ExportProduct extends Products {
    private double exportPrice;
    private String nationImportProduct;

    public ExportProduct() {


    }

    public ExportProduct(int idProduct, String codeProduct, String nameProduct, double price, int quantity, String manufacturer, double exportPrice, String nationImportProduct) {
        super(idProduct, codeProduct, nameProduct, price, quantity, manufacturer);
        exportPrice = exportPrice;
        this.nationImportProduct = nationImportProduct;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        exportPrice = exportPrice;
    }

    public String getNationImportProduct() {
        return nationImportProduct;
    }

    public void setNationImportProduct(String nationImportProduct) {
        this.nationImportProduct = nationImportProduct;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ExportPrice=" + exportPrice +
                ", nationImportProduct='" + nationImportProduct + '\'' +
                "} ";
    }

    public String writeToFileCsv() {
        return super.writeToFileCsv() + ","+ exportPrice+","+  nationImportProduct;
    }
}

