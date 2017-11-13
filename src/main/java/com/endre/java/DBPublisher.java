package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class DBPublisher {

    private ConnectorInterface dbConnector;

    public DBPublisher(ConnectorInterface dbConnector){
        this.dbConnector = dbConnector;
    }

    public void addCountry(Country country) throws SQLException{
            Dao<Country, String> countriesDao = DaoManager.createDao(
                    dbConnector.getConnection(), Country.class);

            countriesDao.createIfNotExists(country);
    }

    public void addCity(City city) throws SQLException{
        Dao<City, String> citiesDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        citiesDao.createIfNotExists(city);
    }

    public void addLanguage(CountryLanguage countryLanguage) throws SQLException {
        Dao<CountryLanguage, String> countrylanguagesDao = DaoManager.createDao(
                dbConnector.getConnection(), CountryLanguage.class);

        countrylanguagesDao.createIfNotExists(countryLanguage);
    }
}
