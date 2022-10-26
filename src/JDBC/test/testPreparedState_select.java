package JDBC.test;

import JDBC.test.utlis.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class testPreparedState_select {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            //和statement的区别：
            //用？占位符代替参数
            String sql = "SELECT * FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setObject(1,2);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                System.out.println(resultSet.getObject("NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }
}
