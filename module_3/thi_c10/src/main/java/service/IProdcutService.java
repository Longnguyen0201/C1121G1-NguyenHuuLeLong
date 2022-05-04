package service;

import model.Catelogy;
import model.Product;

import java.util.List;

public interface IProdcutService {
    List<Product> getAllProduct();

    List<Catelogy> getAllCatelogy();

    void inserInto(Product product);

    void update(Product product);

    void delete(Integer id);

    List<Product> searchProduct(String search);
}
