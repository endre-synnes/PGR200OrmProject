package com.endre.java;

import com.endre.java.DTOs.City;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

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


    public void getAllFromCity() throws Exception{
        Dao<City, String> cityDao = DaoManager.createDao(
                dbConnector.getConnection(), City.class);


        List<City> cities = cityDao.queryForAll();
        printCity(cities);
    }


    private void printCity(List<City> list){
        for (City city : list) {
            System.out.printf(city.toString());
        }
    }

}
