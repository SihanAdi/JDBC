package JDBC.test;

import JDBC.test.utlis.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testDelete {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "DELETE FROM users WHERE id = 4";
            int i = statement.executeUpdate(sql);
            if (i > 0){
                System.out.println("success");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            jdbcUtils.release(connection,statement,resultSet);
        }
    }
}
