package com.cm.sql07;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.cm.pojo.Boys;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws Exception {
        //获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/druid.properties"));

        //获取数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取连接
        Connection connection = dataSource.getConnection();


        //创建查询工具
        QueryRunner queryRunner = new QueryRunner();

        //sql语句
        String sql = "select * from boys where boyName like \"%10\"";

        List<Boys> list = queryRunner.query(connection, sql, new BeanListHandler<>(Boys.class));

        for (Boys value:list){
            System.out.println(value);
        }

    }
}
