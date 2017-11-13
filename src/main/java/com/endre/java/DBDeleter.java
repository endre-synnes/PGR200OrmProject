package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;

public class DBDeleter {

    private ConnectorInterface dbConnector;

    public DBDeleter(ConnectorInterface dbConnector) {
        this.dbConnector = dbConnector;
    }

    public boolean deleteCityByName(String cityName) throws SQLException {
        Dao<City, String> citiesDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        DeleteBuilder<City, String> deleteBuilder = citiesDao.deleteBuilder();
        deleteBuilder.where().eq(City.NAME_FIELD_NAME, cityName);
        deleteBuilder.delete();

        int numberOfCitiesLeftWithThatName = citiesDao
                .queryForEq(City.NAME_FIELD_NAME, cityName).size();
        return numberOfCitiesLeftWithThatName == 0;
    }



    public boolean deleteCountryByCode(String countryCode) throws SQLException{
        Dao<Country, String> countriesDao = DaoManager.createDao(
                dbConnector.getConnection(), Country.class);

        int citiesDeleted = deleteCityByCountryCode(countryCode);
        int languagesDeleted = deleteCountryLanguageByCountryCode(countryCode);
        if (citiesDeleted > 0) System.out.println("Had to delete: " + citiesDeleted +
                " cities that where in this country");
        if (languagesDeleted > 0) System.out.println("Had to delete: " + languagesDeleted +
                " country languages that where in this country");

        DeleteBuilder<Country, String> deleteBuilder = countriesDao.deleteBuilder();
        deleteBuilder.where().eq(Country.CODE_FIELD_NAME, countryCode);
        deleteBuilder.delete();

        int numberOfCountriesLeftWithThatName = countriesDao
                .queryForEq(City.NAME_FIELD_NAME, countryCode).size();
        return numberOfCountriesLeftWithThatName == 0;
    }


    public int deleteCityByCountryCode(String countryCode) throws SQLException{
        Dao<City, String> citiesDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        DeleteBuilder<City, String> deleteBuilder = citiesDao.deleteBuilder();
        deleteBuilder.where().eq(City.COUNTRY_CODE_FIELD_NAME, countryCode);
        return deleteBuilder.delete();
    }

    public int deleteCountryLanguageByCountryCode(String countryCode) throws SQLException {
        Dao<CountryLanguage, String> countryLanguagesDao = DaoManager.createDao(
                dbConnector.getConnection(), CountryLanguage.class);

        DeleteBuilder<CountryLanguage, String> deleteBuilder = countryLanguagesDao.deleteBuilder();
        deleteBuilder.where().eq(CountryLanguage.COUNTRY_CODE_FIELD_NAME, countryCode);
        return deleteBuilder.delete();
    }


}
