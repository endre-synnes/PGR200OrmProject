package com.endre.java;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector implements ConnectorInterface{
    private static String hostName;
    private static String dbName;
    private static String userName;
    private static String password;
    private static String port;

    public DBConnector(String properties) throws IOException{
        try {
            FileInputStream fileInputStream = new FileInputStream(properties);
            Properties prop = new Properties();
            prop.load(fileInputStream);
            hostName = prop.getProperty("hostName");
            dbName = prop.getProperty("dbName");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
            port = prop.getProperty("port");
        }catch (IOException e){
            throw new IOException("Could not read properties-file");
        }
    }


    public ConnectionSource getConnection() throws SQLException{
        String urlString = "jdbc:mysql://" + hostName +":" + port + "/" + dbName;
        return new JdbcConnectionSource(urlString, userName, password);
    }

}
