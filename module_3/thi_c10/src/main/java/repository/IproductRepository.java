package repository;

import model.Catelogy;
import model.Product;

import java.util.List;

public interface IproductRepository {
    List<Product> getAllProduct();

    List<Catelogy> getAllCatelogy();

    void insertInto(Product product);

    void update(Product product);

    void delete(Integer id);

    List<Product> searchProduct(String search);
}
