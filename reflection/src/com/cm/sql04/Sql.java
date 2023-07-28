package com.cm.sql04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class Sql {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Properties properties = new Properties();
        properties.load(new FileInputStream("reflection/src/db.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);

        try {
             connection = DriverManager.getConnection(url, user, password);

            String sql = "insert into boys values(null,?,?)";

             preparedStatement = connection.prepareStatement(sql);

            System.out.println(new Date());
            for (int i = 0 ; i <1000; i++){
                preparedStatement.setString(1,"小明"+i);
                preparedStatement.setString(2,i+"");
                preparedStatement.addBatch();
                if(i+1 == 1000){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            System.out.println(new Date());
        }catch (Exception e){
            e.printStackTrace();
        }

        preparedStatement.close();
        connection.close();

    }
}
