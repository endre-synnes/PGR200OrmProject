package com.endre.java;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionSource implements ConnectorInterface {

    public ConnectionSource getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        }catch (ClassNotFoundException e){
            throw new SQLException("Unable to find H2 driver");
        }
        return new JdbcConnectionSource("jdbc:h2:~/things", "sa", "");
    }
}
