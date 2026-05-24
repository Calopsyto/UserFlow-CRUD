package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);

            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);
            }
            return connection;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void rollbackTransation(Exception e) {
        try {
            connection.rollback();
            throw new DbException(e.getMessage());
        } catch (SQLException ex) {
            throw new DbException(e.getMessage() + "Rollback Fail");
        }
    }
}
