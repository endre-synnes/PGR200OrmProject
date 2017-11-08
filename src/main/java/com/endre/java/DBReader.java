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

}
