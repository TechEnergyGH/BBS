package main.java.forum.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;

public class DBUtil {
    private static final DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        // 数据库路径要正确
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/bbs?useSSL=false&serverTimezone=UTC");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        dataSource = mysqlDataSource;
    }

    @SneakyThrows
    public static Connection connection() {
        return dataSource.getConnection();
    }

}
