package service.impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "Sony XZ1", "12000000", "Gray", "Sony"));
        productList.put(2, new Product(2, "Iphone 11", "18000000", "White", "Apple"));
        productList.put(3, new Product(3, "Samsung A32", "9000000", "Black", "Samsung"));
        productList.put(4, new Product(4, "Oppo A11 ", "10000000", "Blue", "Oppo"));
    }

    @Override
    public Product findByID(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
