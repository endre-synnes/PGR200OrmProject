package com.endre.java;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public interface ConnectorInterface {


    ConnectionSource getConnection() throws SQLException;

}
