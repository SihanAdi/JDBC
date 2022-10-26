package JDBC;

import java.sql.*;

public class first_jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动，这个现在应该是不需要了
        //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
        // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

//        Class.forName("com.mysql.jdbc.Driver");
        //用户信息和url
        //mysql--3306
        //协议：//主机地址：端口号/数据库名？参数
        //oracle--1521
        //jdbc:oracle:thin:@localhost:1521:sid
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useSSL=true";
        String username = "root";
        String password = "Sunyu980702.";
        //连接成功，数据库对象
        //connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //        connection.setAutoCommit();//数据库设置自动提交
        //        connection.commit();//事务提交
        //        connection.rollback();//事务回滚
        //执行sql对象
        //statement执行sql对象
        //        prepareStatement()执行sql对象
        Statement statement = connection.createStatement();

        //执行sql
        String sql = "SELECT * FROM users";
        //        statement.execute();//执行任何sql
        //        statement.executeUpdate();//更新，插入，删除。都用这个，返回一个受影响的行数
        //        statement.executeQuery(sql);//查询操作返回resultSet
        ResultSet resultSet = statement.executeQuery(sql);//返回的结果集，结果集中封装了我们全部的查询结果

        //        resultSet.getObject();//在不知道列的类型的情况下使用
        //如果知道列的类型就使用指定的类型
        //        resultSet.getShort();
        //        resultSet.getString();
        //        resultSet.getDate();
        //        resultSet.getInt();
        while (resultSet.next()){
//            resultSet.beforeFirst();//移动到最前面
//            resultSet.absolute(row);//移动到指定的行
//            resultSet.afterLast();//移动到最后面
//            resultSet.next();//移动到下一个数据
//            resultSet.previous();//移动到前一行
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("pwd=" + resultSet.getObject("PASSWORD"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birth=" + resultSet.getObject("birthday"));
            System.out.println("=====================================================");
        }
        //释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
