package com.endre.java;

import java.io.IOException;

public class MainApplication {
    private DBConnector dbConnector;

    public MainApplication(DBConnector dbConnector) throws Exception {
        this.dbConnector = dbConnector;
    }

    public void createDB()throws Exception{
        System.out.println("Creating tables");
        new DBCreator(dbConnector).setUpDatabase();
    }


    public void readFromDB()throws Exception{
//        System.out.println("Getting Oslo From City...");
//        new DBReader(dbConnector).getOsloFromCity();
//        System.out.println("Getting all From City");
//        new DBReader(dbConnector).getCountryStartingWithN();
    }

    public void publishToDB()throws Exception{
        System.out.println("Adding Norway to countries");
        new DBPublisher(dbConnector).addCountry();
    }

    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector("DatabaseProperties.properties");

            MainApplication mainApplication = new MainApplication(dbConnector);

            mainApplication.createDB();

            mainApplication.readFromDB();

            mainApplication.publishToDB();


        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
