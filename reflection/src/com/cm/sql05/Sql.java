package com.cm.sql05;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * C3P0
 */
public class Sql {

    public static void main(String[] args) throws Exception {
//        //数据源
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//
//        //获取配置信息
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("reflection/src/db.properties"));
//
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//
//        //配置数据源连接信息
//        comboPooledDataSource.setDriverClass(driver);
//        comboPooledDataSource.setJdbcUrl(url);
//        comboPooledDataSource.setUser(user);
//        comboPooledDataSource.setPassword(password);
//
//        //设置初始化连接数
//        comboPooledDataSource.setInitialPoolSize(10);
//        //最大连接数
//        comboPooledDataSource.setMaxPoolSize(50);
//
//        //获取连接
//        Connection connection = comboPooledDataSource.getConnection();


        //根据数据源名获取数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("test");


        Connection connection = comboPooledDataSource.getConnection();


    }
}
