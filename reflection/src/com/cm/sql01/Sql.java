package com.cm.sql01;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","hh0512..");

        //获取连接
        Connection connect = driver.connect(url, properties);

        //获取statement
        Statement statement = connect.createStatement();

        //sql语句
        String sql ="select * from girls";

        //执行语句
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            String phone = resultSet.getString(5);
            System.out.println("id:"+id+"name:"+name+"sex:"+sex+"borthday:"+borndate+"phone:"+phone);
        }

        //关闭资源
        connect.close();
        statement.close();
        resultSet.close();
    }
}
