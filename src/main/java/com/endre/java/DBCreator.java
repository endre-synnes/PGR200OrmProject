package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.Countrylanguage;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBCreator {
    private DBConnector dbConnector;

    public DBCreator(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public void tearDownTables() throws SQLException {
        TableUtils.dropTable(dbConnector.getConnection(), City.class, true);
        TableUtils.dropTable(dbConnector.getConnection(), Countrylanguage.class, true);
        TableUtils.dropTable(dbConnector.getConnection(), Country.class, true);
    }

    public void setUpDatabase() throws SQLException{
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), Country.class);
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), City.class);
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), Countrylanguage.class);
    }
}
