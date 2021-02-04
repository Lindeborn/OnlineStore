package Controller;

import java.sql.*;

public class SqlServerConnection {
    public SqlServerConnection(){

    }

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbURL = "jdbc:sqlserver://localhost";

        String user = "StoreAdmin";
        String password = "password123";

        Connection connection = DriverManager.getConnection(dbURL, user, password);
        if (connection != null) {
            System.out.println("connected");
            return connection;
        }

        return null;
    }

    public static void main(String[] args){
        SqlServerConnection sql = new SqlServerConnection();
        try{
            Connection connection = sql.connect();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
