package model.impl;

import db.DB;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void update(User user) {
        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE User SET Name = ?, Email = ?, BirthDate = ?, Age = ? WHERE Id = ?"
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(simpleDateFormat.parse(user.getBirthDate()).getTime()));
            preparedStatement.setInt(4, user.getAge());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows Affected: " + rowsAffected);

            connection.commit();

        } catch (SQLException | ParseException e) {
            DB.rollbackTransation(e);
        }

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
