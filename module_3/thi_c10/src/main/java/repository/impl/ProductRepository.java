package repository.impl;

import model.Catelogy;
import model.Product;
import repository.BaseRepository;
import repository.IproductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IproductRepository {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Product> getAllProduct() {
        ProductRepository productRepository = new ProductRepository();
        List<Product> productList = new ArrayList<>();
        String query = "select * from prodcut";
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Catelogy catelogy = productRepository.catelogy(rs.getInt(7));
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        catelogy);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productList;
    }

    @Override
    public List<Catelogy> getAllCatelogy() {
        List<Catelogy> catelogyList = new ArrayList<>();
        Catelogy catelogy = null;
        String query = "select * from catelogy";
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                catelogy = new Catelogy(rs.getInt(1),
                        rs.getString(2));
                catelogyList.add(catelogy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return catelogyList;
    }

    @Override
    public void insertInto(Product product) {
        String query = "insert into prodcut values (?,?,?,?,?,?,?)";

        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getAmount());
            ps.setString(5, product.getColor());
            ps.setString(6, product.getDescription());
            ps.setInt(7, product.getCatelogy().getCatelogyId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        String query = "update prodcut \n" +
                "set name=?,price=?,amount=?,color=?,`description`=?,catelogy_id=? where id=?;";
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getAmount());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getCatelogy().getCatelogyId());
            ps.setInt(7, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Integer id) {
        String qury = "delete from prodcut where id =?;";
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(qury);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Product> searchProduct(String search) {
        ProductRepository productRepository = new ProductRepository();
        List<Product> productList = new ArrayList<>();
        String query = "select * from prodcut where `name` like ?;";
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+search+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                Catelogy catelogy = productRepository.catelogy(rs.getInt(7));
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        catelogy);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productList;
    }

    private Catelogy catelogy(int id) {
        String query = "select * from catelogy where catelogy_id =?;";
        Catelogy catelogy = null;
        try {
            conn = BaseRepository.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                catelogy = new Catelogy(rs.getInt(1),
                        rs.getString(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return catelogy;
    }

}
