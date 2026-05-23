package model.impl;

import db.DB;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO user (Name, Email, Age, BirthDate) VALUES (?, ?, ?, ?)"
            );

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setDate(4, new java.sql.Date(simpleDateFormat.parse(user.getBirthDate()).getTime()));

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows Affected: " + rowsAffected);

        } catch (SQLException | ParseException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        
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
