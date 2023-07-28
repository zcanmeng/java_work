package com.cm.sql06;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws Exception {
        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/druid.properties"));

        //创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取连接
        Connection connection = dataSource.getConnection();
    }
}
