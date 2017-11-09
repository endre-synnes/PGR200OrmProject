package com.endre.java;

import java.io.IOException;

public class MainApplication {
    private DBConnector dbConnector;

    public MainApplication(DBConnector dbConnector) throws Exception {
        this.dbConnector = dbConnector;
    }

    public void readFromDB()throws Exception{
        System.out.println("Getting Oslo From City...");
        new DBReader(dbConnector).getOsloFromCity();
        System.out.println("Getting all From City");
        new DBReader(dbConnector).getAllFromCity();
    }

    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector("DatabaseProperties.properties");

            MainApplication mainApplication = new MainApplication(dbConnector);

            //Setting up tables
            new DBCreator(dbConnector).setUpDatabase();

            mainApplication.readFromDB();




        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
