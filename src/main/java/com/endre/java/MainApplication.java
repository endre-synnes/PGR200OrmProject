package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.Countrylanguage;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.spring.DaoFactory;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    private DBConnector dbConnector;

    public MainApplication(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector("DatabaseProperties.properties");

            MainApplication mainApplication = new MainApplication(dbConnector);

            //Setting up tables
            new DBCreator(dbConnector).setUpDatabase();

            Dao<City, String> cityDao = DaoManager.createDao(
                    dbConnector.getConnection(), City.class);



            List<City> cities = cityDao.queryForEq(City.NAME_FIELD_NAME, "Oslo");
            System.out.println("City: " + cities.get(0).getName());




        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
