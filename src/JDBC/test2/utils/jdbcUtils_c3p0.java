package JDBC.test2.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtils_c3p0 {
    private static ComboPooledDataSource dataSource = null;
    static {
        try {
//            代码版配置
//            dataSource = new ComboPooledDataSource();
//            dataSource.setDriverClass();
//            dataSource.setUser();
//            dataSource.setJdbcUrl();
//            dataSource.setPassword();
//            dataSource.setMaxPoolSize();
//            dataSource.setMinPoolSize();
            //创建数据源
            dataSource = new ComboPooledDataSource("MySQL");//配置文件写法

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //获取资源
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();//从数据源中获取连接
    }
    //释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
