package main.java.forum;

import main.java.forum.GUI.MainScreen;
import main.java.forum.util.DBUtil;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //主界面
        MainScreen ms = new MainScreen();

        /*Connection connection = DBUtil.connection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM user;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("uID:" + resultSet.getString("uID"));
        }
        resultSet.close();
        statement.close();
        connection.close();*/
    }
}
