package com.program.javafx.DatabaseConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnection {

    private Connection conn = null;
    private Properties properties;

    public Connection getConnection(){
        Properties properties = loadProperties();
        String url = properties.getProperty("dburl");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        try {
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Connect complete!");
            return conn;
        }catch (Exception ex){
            System.out.println("Всё печально((");
        }
            return null;
    }

    private Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("DriverManager.properties")){
            properties = new Properties();
            properties.load(fs);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

}
