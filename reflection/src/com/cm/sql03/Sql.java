package com.cm.sql03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/db.properties"));

        //配置信息
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String name = properties.getProperty("user");
        String password = properties.getProperty("password");

        //加载驱动
        Class.forName(driver);

        //使用DriverManager获取连接
        Connection connection = DriverManager.getConnection(url, name, password);

        //开启事务
        connection.setAutoCommit(false);

        //sql语句
        String sql1 = "update boys set userCP = 800 where id = 2";
        String sql2 = "update boys set userCP = 100 where id = 1";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql1);
            boolean execute = preparedStatement.execute();

            int i = 1 / 0;

            preparedStatement= connection.prepareStatement(sql2);
            boolean execute1 = preparedStatement.execute();

            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }


        preparedStatement.close();
        connection.close();

    }
}
