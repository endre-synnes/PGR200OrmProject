package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.Countrylanguage;
import com.j256.ormlite.table.TableUtils;

public class DBCreator {
    private DBConnector dbConnector;

    public DBCreator(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }


    public void setUpDatabase() throws Exception{
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), City.class);
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), Country.class);
        TableUtils.createTableIfNotExists(dbConnector.getConnection(), Countrylanguage.class);
    }
}
