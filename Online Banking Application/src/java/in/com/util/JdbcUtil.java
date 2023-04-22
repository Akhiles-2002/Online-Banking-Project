package in.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JdbcUtil {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    // No one can create object of JdbcUtil causes of Private Constructor
    private JdbcUtil() {

    }

    static {
        // loading and register the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    public static Connection getJdbcConnection() {
        try {
            // Take the data from properties file
            FileInputStream fis = new FileInputStream(
                    "E:\\NetBeansProjects\\Online Banking Application\\src\\java\\in\\com\\properties\\application.properties");
            Properties properties = new Properties();

            properties.load(fis);

            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
                    properties.getProperty("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static int getPrimaryKey() {
        int primarykey = 0;

        connection = JdbcUtil.getJdbcConnection();
        String sqlQuery = "select customerId from customer";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);

            if (preparedStatement != null) {
                resultSet = preparedStatement.executeQuery();
            }
            if (resultSet != null) {
                primarykey = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return primarykey;
    }

    public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
