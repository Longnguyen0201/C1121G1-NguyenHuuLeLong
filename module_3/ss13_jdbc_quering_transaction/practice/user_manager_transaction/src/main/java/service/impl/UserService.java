package service.impl;

import model.User;
import repository.iml.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    UserRepository userRepository = new UserRepository();


    @Override
    public void insertUser(User user) throws SQLException {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) throws SQLException {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchCountry( String country) {
         return userRepository.searchCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User newUser) throws SQLException {
        userRepository.insertUserStore(newUser);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }
}
