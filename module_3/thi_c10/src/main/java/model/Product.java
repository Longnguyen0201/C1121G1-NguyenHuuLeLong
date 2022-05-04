package model;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private Integer amount;
    private  String color;
    private String description;
    private Catelogy catelogy;

    public Product(Integer id, String name, double price, Integer amount, String color, String description, Catelogy catelogy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.catelogy = catelogy;
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catelogy getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(Catelogy catelogy) {
        this.catelogy = catelogy;
    }


}
