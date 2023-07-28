package com.cm.sql02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //获取配置信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection\\src\\db.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //加载驱动
        Class.forName(driver);

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        String name = "小龙女";

        //sql语句
        String sql = "select * from girls where name = ?";

        //获取PreparedStatement对象，并进行预处理sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //填入数据
        preparedStatement.setString(1,name);

        //执行
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            String phone = resultSet.getString(5);
            System.out.println("id:"+id+"name:"+username+"sex:"+sex+"borthday:"+borndate+"phone:"+phone);
        }

    }
}
