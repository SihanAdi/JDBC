package JDBC.test2;

import JDBC.test2.utils.jdbcUtils_DBCP;
import JDBC.test2.utils.jdbcUtils_c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test_c3p0 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = jdbcUtils_c3p0.getConnection();
            //和statement的区别：
            //用？占位符代替参数
            String sql = "INSERT INTO users(id, NAME, PASSWORD, email, birthday) VALUES(?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setObject(1,6);
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
            jdbcUtils_c3p0.release(connection,preparedStatement,null);
        }
    }
}
