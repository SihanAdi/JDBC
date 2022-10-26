package JDBC.test2;

import JDBC.test.utlis.jdbcUtils;
import JDBC.test2.utils.jdbcUtils_DBCP;

import java.sql.*;

public class test_DBCP {
    //应该是配置文件有问题
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = jdbcUtils_DBCP.getConnection();
            //和statement的区别：
            //用？占位符代替参数
            String sql = "INSERT INTO users(id, NAME, PASSWORD, email, birthday) VALUES(?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setObject(1,5);
            preparedStatement.setObject(2,"adsh");
            preparedStatement.setObject(3,"232334");
            preparedStatement.setObject(4,"99ad@qq.com");
            //sql.Date 数据库 java.sql.Date()
            //util.Date Java new Date().getTime()获得时间戳
            preparedStatement.setObject(5, new java.sql.Date(new java.util.Date().getTime()));

            int i = preparedStatement.executeUpdate();
            if (i > 0){
                System.out.println("success");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils_DBCP.release(connection,preparedStatement,null);
        }
    }
}
