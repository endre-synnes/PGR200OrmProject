package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class DBReader {

    private ConnectorInterface dbConnector;


    public DBReader(ConnectorInterface dbConnector){
        this.dbConnector = dbConnector;
    }

    public List<City> getAllCities() throws SQLException{
        Dao<City, String> citiesDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        List<City> cities = citiesDao.queryForAll();
        printCity(cities);
        return cities;
    }

    public List<Country> getAllCountries() throws SQLException{
        Dao<Country, String> countriesDao = DaoManager.createDao(
                dbConnector.getConnection(), Country.class);

        List<Country> countries = countriesDao.queryForAll();
        printCountry(countries);
        return countries;
    }

    public List<CountryLanguage> getAllCountyLanguages() throws SQLException {
        Dao<CountryLanguage, String> countryLanguagesDao = DaoManager.createDao(
                dbConnector.getConnection(), CountryLanguage.class);

        List<CountryLanguage> countryLanguages = countryLanguagesDao.queryForAll();
        printCountryLanguages(countryLanguages);
        return countryLanguages;
    }


    public List<City> getCityByName(String cityName) throws SQLException{
        Dao<City, String> cityDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        List<City> cities = cityDao.queryForEq(City.NAME_FIELD_NAME, cityName);
        printCity(cities);
        return cities;
    }


    public List<Country> getCountryByName(String countryName) throws SQLException{
        Dao<Country, String> countriesDao = DaoManager.createDao(
                dbConnector.getConnection(), Country.class);
        Country country = new Country();
        country.setName(countryName);
        List<Country> countries = countriesDao
                .queryBuilder().where().like("Name", country.getName()).query();
        printCountry(countries);
        return countries;
    }


    private void printCity(List<City> list){
        for (City city : list) {
            System.out.printf(city.toString());
        }
    }

    private void printCountry(List<Country> list){
        for (Country country : list) {
            System.out.printf(country.toString());
        }
    }

    private void printCountryLanguages(List<CountryLanguage> countryLanguages) {
        for (CountryLanguage language :countryLanguages) {
            System.out.println(language.toString());
        }
    }

}
