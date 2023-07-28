package com.cm.sql06;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            //获取配置文件
            properties.load(new FileInputStream("reflection/src/druid.properties"));

            //获取数据源
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //关闭资源
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if (resultSet!= null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
