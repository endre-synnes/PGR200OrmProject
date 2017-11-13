package com.endre.java;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication {
    private DBConnector dbConnector;

    public MainApplication(DBConnector dbConnector) throws Exception {
        this.dbConnector = dbConnector;
    }

    public void createDB()throws Exception{
        System.out.println("Tearing down tables...");
        new DBCreator(dbConnector).tearDownTables();
        System.out.println("Creating tables...");
        new DBCreator(dbConnector).setUpDatabase();
    }

    public void publishToDB()throws Exception{
        System.out.println("Adding Norway to countries...");
        System.out.println("Adding Oslo to Cities...");
        System.out.println("Adding Bergen to Cities...");
        new DBPublisher(dbConnector).addCountryAndTwoCities();
    }

    public void readFromDB()throws Exception{
        System.out.println("Getting Oslo from City...");
        new DBReader(dbConnector).getOsloFromCity();
        System.out.println("Getting Norway from Countries...");
        new DBReader(dbConnector).getCountryNorway();
    }

    public void updateValueInDB()throws SQLException{
        System.out.println("Updating Norway indep-year to 1814...");
        new DBUpdator(dbConnector).updateCountryIndepYear("Norway", 1814);
    }



    public static void main(String[] args) {
        try {
            DBConnector dbConnector = new DBConnector("DatabaseProperties.properties");

            MainApplication mainApplication = new MainApplication(dbConnector);

            mainApplication.createDB();

            mainApplication.publishToDB();

            mainApplication.readFromDB();

            mainApplication.updateValueInDB();



        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
