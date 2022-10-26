package JDBC.test;

import JDBC.test.utlis.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class testPreparedState_delete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//可以防止sql注入
        try {
            connection = jdbcUtils.getConnection();
            //和statement的区别：
            //用？占位符代替参数
            String sql = "DELETE FROM users WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);//预编译sql，先写sql，然后不执行
            //手动给参数赋值
            preparedStatement.setObject(1,4);


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
