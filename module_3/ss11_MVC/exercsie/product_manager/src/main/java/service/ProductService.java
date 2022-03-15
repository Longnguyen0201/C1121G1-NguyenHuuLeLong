package service;

import model.Product;

import java.util.List;

public interface ProductService {
    Product findByID(int id);

    List<Product> findAll();

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);
}
