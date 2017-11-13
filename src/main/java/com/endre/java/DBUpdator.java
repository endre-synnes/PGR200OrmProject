package com.endre.java;

import com.endre.java.DTOs.Country;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;

public class DBUpdator {

    private DBConnector dbConnector;

    public DBUpdator(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public void updateCountryIndepYear(String countryName, int newIndepYear) throws SQLException{
        try {
            Dao<Country, String> countriesDao = DaoManager.createDao(
                    dbConnector.getConnection(), Country.class);


            UpdateBuilder<Country, String> updateBuilder = countriesDao.updateBuilder();
            updateBuilder.where().eq(Country.NAME_FIELD_NAME, countryName);
            updateBuilder.updateColumnValue(Country.INDEP_YEAR_FIELD_NAME, newIndepYear);
            updateBuilder.update();

        }catch (SQLException se){
            throw new SQLException("Could not update IndepYear");
        }

    }
}
