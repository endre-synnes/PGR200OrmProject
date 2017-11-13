package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBCreator {
    private ConnectorInterface dbConnector;

    public DBCreator(ConnectorInterface dbConnector){
        this.dbConnector = dbConnector;
    }

    public void tearDownTables() throws SQLException {
        TableUtils.dropTable(dbConnector.getConnection(), City.class, true);
        TableUtils.dropTable(dbConnector.getConnection(), CountryLanguage.class, true);
        TableUtils.dropTable(dbConnector.getConnection(), Country.class, true);
    }

    public int setUpDatabase() throws SQLException{
        int country = TableUtils.createTableIfNotExists(dbConnector.getConnection(), Country.class);
        int city = TableUtils.createTableIfNotExists(dbConnector.getConnection(), City.class);
        int language = TableUtils.createTableIfNotExists(dbConnector.getConnection(), CountryLanguage.class);
        return country + city + language;
    }
}
