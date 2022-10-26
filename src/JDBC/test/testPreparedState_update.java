package JDBC.test;

import JDBC.test.utlis.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testPreparedState_update {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = jdbcUtils.getConnection();
            //和statement的区别：
            //用？占位符代替参数
            String sql = "UPDATE users SET NAME = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setObject(1,"sh");
            preparedStatement.setObject(2,2);


            int i = preparedStatement.executeUpdate();
            if (i > 0){
                System.out.println("success");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.release(connection,preparedStatement,null);
        }
    }
}
