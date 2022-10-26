package JDBC.test;

import JDBC.test.utlis.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            //关闭数据库的自动提交，自动会开启事务
            connection.setAutoCommit(false);

            String sql1 = "UPDATE accout SET money = money + 500 WHERE name = 'A'";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            String sql2 = "UPDATE accout SET money = money + 500 WHERE name = 'A'";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            //业务完毕，提交事务
            connection.commit();
            System.out.println("success");
        } catch (SQLException e) {
            //如果失败默认回滚
            connection.rollback();//如果失败则回滚事务
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.release(connection,preparedStatement,null);
        }
    }
}
