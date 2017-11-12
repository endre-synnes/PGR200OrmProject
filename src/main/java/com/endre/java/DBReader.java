package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.util.List;

public class DBReader {

    private DBConnector dbConnector;


    public DBReader(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }


    public void getOsloFromCity() throws Exception{
        Dao<City, String> cityDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);

        List<City> cities = cityDao.queryForEq(City.NAME_FIELD_NAME, "Oslo");
        printCity(cities);
    }


    public void getCountryStartingWithN() throws Exception{
        Dao<Country, String> countriesDao = DaoManager.createDao(
                dbConnector.getConnection(), Country.class);
        Country country = new Country();
        country.setName("Norway");
        List<Country> countries = countriesDao
                .queryBuilder().where().like("Name", country.getName()).query();
        printCountry(countries);
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

}
