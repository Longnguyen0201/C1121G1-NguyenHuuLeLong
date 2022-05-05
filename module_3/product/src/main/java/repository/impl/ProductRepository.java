package repository.impl;

import DTO.ProductDTO;
import models.Category;
import models.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<ProductDTO> getAllProduct() {

        List<ProductDTO> productList = new ArrayList<>();
        String query = "select id,product_name,product_price,quantity,color,categogy.categogy_name from product\n" +
                "inner join categogy on categogy.categogy_id= product.categogy_id\n" +
                "order by id;";
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new ProductDTO(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> catelogyList = new ArrayList<>();
        Category catelogy = null;
        String query = "select * from categogy";
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                catelogyList.add(new Category(resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return catelogyList;
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(product_name, " +
                    "product_price,quantity,color,categogy_id) value (?,?,?,?,?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean delete(Integer id) {
        boolean rowDelete = false;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDelete;
    }

    @Override
    public Product selectById(Integer id) {
        Product product = null;
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from product where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer idProduct = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Integer quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                Integer category = resultSet.getInt(6);
                product = new Product(idProduct, name, price, quantity, color, category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        boolean rowUpdate = false;

        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" update  product set product_name = ?, " +
                    "product_price=?,quantity=?,color=?,categogy_id=?\n" +
                    " where id=?;");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory());
            preparedStatement.setInt(6, product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdate;
    }

    @Override
    public List<ProductDTO> searchByName(String search) {
        List<ProductDTO> searchList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id,product_name,product_price, " +
                    "quantity,color,categogy.categogy_name from product\n" +
                    "inner join categogy on categogy.categogy_id= product.categogy_id where product_name like ?" +
                    "order by id;");
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer idProduct = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Integer quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String category = resultSet.getString(6);
                searchList.add(new ProductDTO(idProduct, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return searchList;
    }
}
