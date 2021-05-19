package todo.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    public static DatabaseHandler databaseHandler = new DatabaseHandler();
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String name, String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" + Constants.USERS_NAME + ","
                + Constants.USERS_LOGIN + "," + Constants.USERS_Password + ")" + "VALUES(?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public ResultSet getUser(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USERS_LOGIN + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, login);

        resultSet = preparedStatement.executeQuery();
        //preparedStatement.close();

        return resultSet;

    }


}
