package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(int id) throws SQLException;

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchCountry(String country);

    List<User> sortByName();

    User getUserById(int id);

    void  insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user,int[] permision);



}
