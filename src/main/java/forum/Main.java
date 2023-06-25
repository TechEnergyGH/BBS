package main.java.forum;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/bbs?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
//        3.连接成功，数据库对象 Connection
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM user;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("uID:" + resultSet.getString("uID"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
