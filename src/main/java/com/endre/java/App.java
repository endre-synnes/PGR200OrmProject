package com.endre.java;

import com.endre.java.DTOs.City;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String databaseURL = "jdbc:mysql://localhost:3306/world";

        ConnectionSource connectionSource = new JdbcConnectionSource(
                databaseURL, "root", "root");

        Dao<City, String> cityDao = DaoManager.createDao(
                connectionSource, City.class);


        //Test if table exist
        TableUtils.createTableIfNotExists(connectionSource, City.class);


        List<City> cities = cityDao.queryForEq(City.NAME_FIELD_NAME, "Oslo");
        System.out.println("City: " + cities.get(0).getName());
    }
}
