package repository;

import DTO.ProductDTO;
import models.Category;
import models.Product;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> getAllProduct();

    List<Category> getAllCategory();

    void createProduct(Product product);

    boolean delete(Integer id);

    Product selectById(Integer id);

    boolean update(Product product);

    List<ProductDTO> searchByName(String search);
}
