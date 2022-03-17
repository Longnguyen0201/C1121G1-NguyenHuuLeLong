package repository.iml;

import model.User;
import repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private BaseRepository baseRepository = new BaseRepository();


    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUE(?,?,?);";
    private static final String SELECT_USERS_BY_ID = "select id,name,email,country from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name=?, email=?, country =? where id = ?;";


    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    @Override
    public User selectUser(int id) throws SQLException {
        User user = null;
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idUser = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            user = new User(idUser, name, email, country);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
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
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        connection.close();
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, user.getId());
        rowUpdate = preparedStatement.executeUpdate() > 0;
        connection.close();
        return rowUpdate;
    }

    @Override
    public List<User> searchCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select id,name,email,country from users where country like concat(\"%\",?,\"%\")");

            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryUser = resultSet.getString("country");
                userList.add(new User(id, name, email, countryUser));
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
        return userList;
    }

    @Override
    public List<User> sortByName() {
        List<User> sortList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users order by name asc;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryUser = resultSet.getString("country");
                sortList.add(new User(id, name, email, countryUser));
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
        return sortList;
    }
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);
            statement.executeUpdate(SQL_TABLE_DROP);
            statement.executeUpdate(SQL_TABLE_CREATE);

            preparedStatementInsert.setString(1,"Quynh");
            preparedStatementInsert.setBigDecimal(2,new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));

            preparedStatementInsert.execute();

            preparedStatementInsert.setString(1,"Ngan");
            preparedStatementInsert.setBigDecimal(2,new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));

            preparedStatementUpdate.setBigDecimal(2,new BigDecimal(999.99));
            preparedStatementUpdate.setString(2,"Quynh");

            preparedStatementUpdate.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}
