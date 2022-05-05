package service.impl;

import DTO.ProductDTO;
import models.Category;
import models.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public List<Category> getAllCategory() {
        return productRepository.getAllCategory();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    @Override
    public Product selectById(Integer id) {

        return productRepository.selectById(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public List<ProductDTO> searchByName(String search) {
        return productRepository.searchByName(search);
    }
}
