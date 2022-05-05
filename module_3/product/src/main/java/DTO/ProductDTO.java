package DTO;

public class ProductDTO {
    private  Integer id ;
    private  String name;
    private  Double price;
    private  Integer quantity;
    private String color;
    private  String categoryName;

    public ProductDTO(Integer id, String name, Double price, Integer quantity, String color, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryName = categoryName;
    }

    public ProductDTO(String name, Double price, Integer quantity, String color, String categoryName) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryName = categoryName;
    }

    public ProductDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
