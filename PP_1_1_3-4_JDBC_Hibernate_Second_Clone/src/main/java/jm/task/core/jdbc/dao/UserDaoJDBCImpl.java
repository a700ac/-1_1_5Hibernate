//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.entity.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.sql.DriverManager.getConnection;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        Connection connection = getConnection();
//        String sql = "CREATE TABLE IF NOT EXISTS users(" +
//                "ID BIGINT NOT NULL AUTO_INCREMENT, NAME VARCHAR(45), " +
//                "LASTNAME VARCHAR(45), AGE TINYINT, PRIMARY KEY (ID) )";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        Connection connection = getConnection();
//        String sql = "DROP TABLE IF EXISTS users";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        Connection connection = getConnection();
//        String sql = "INSERT INTO users (NAME, LASTNAME, AGE) VALUES(?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        Connection connection = getConnection();
//        String sql = "DELETE FROM users WHERE ID=?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        String sql = "SELECT ID, NAME, LASTNAME, AGE FROM users";
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement()) {
//             ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("ID"));
//                user.setName(resultSet.getString("NAME"));
//                user.setLastName(resultSet.getString("LASTNAME"));
//                user.setAge(resultSet.getByte("AGE"));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//        Connection connection = getConnection();
//        String sql = "DELETE  FROM users";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
