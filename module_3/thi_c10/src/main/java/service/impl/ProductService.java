package service.impl;

import model.Catelogy;
import model.Product;
import repository.IproductRepository;
import repository.impl.ProductRepository;
import service.IProdcutService;

import java.util.List;

public class ProductService implements IProdcutService {
    IproductRepository iproductRepository = new ProductRepository();

    @Override
    public List<Product> getAllProduct() {
        return iproductRepository.getAllProduct();
    }

    @Override
    public List<Catelogy> getAllCatelogy() {
        return iproductRepository.getAllCatelogy();
    }

    @Override
    public void inserInto(Product product) {
        iproductRepository.insertInto(product);

    }

    @Override
    public void update(Product product) {
        iproductRepository.update(product);
    }

    @Override
    public void delete(Integer id) {
        iproductRepository.delete(id);
    }

    @Override
    public List<Product> searchProduct(String search) {
        return iproductRepository.searchProduct(search);
    }
}
