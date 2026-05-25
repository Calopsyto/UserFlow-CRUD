package model.impl;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.UserDao;
import model.entities.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDao {

    private final Connection connection;

    public UserDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            ResultSet resultSet;
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO user (Name, Email, Age, BirthDate) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setDate(4, new java.sql.Date(simpleDateFormat.parse(user.getBirthDate()).getTime()));

            int rowsAffected = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            System.out.println("Rows Affected: " + rowsAffected);
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
            }
            connection.commit();

        } catch (SQLException | ParseException e) {
            DB.rollbackTransation(e);
        }
    }

    @Override
    public void update(User user, Integer id) {
        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE User SET Name = ?, Email = ?, BirthDate = ?, Age = ? WHERE Id = ?"
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(simpleDateFormat.parse(user.getBirthDate()).getTime()));
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, id);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Affected: " + rowsAffected);

            connection.commit();

        } catch (SQLException | ParseException e) {
            DB.rollbackTransation(e);
        }

    }

    @Override
    public void deleteById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM User WHERE Id = ?"
            );

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                throw new DbIntegrityException(e.getMessage());
            } else {
                throw new DbException(e.getMessage());
            }
        }
    }

    @Override
    public User findById(Integer id) {
        try {
            User user = null;
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM User WHERE Id = ?"
            );
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 user = new User(
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        String.valueOf(resultSet.getString("BirthDate")),
                        resultSet.getInt("Age"));
            }

            return user;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            List<User> userList = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getString("BirthDate"),
                        resultSet.getInt("Age"));
                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
