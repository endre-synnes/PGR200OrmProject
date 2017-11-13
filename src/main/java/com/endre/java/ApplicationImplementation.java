package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;

import java.sql.SQLException;


public class ApplicationImplementation {
//    private DBConnector dbConnector;

    private ConnectorInterface dbConnector;


    public ApplicationImplementation(String properties) throws Exception {
        dbConnector = new DBConnector(properties);
    }

    public void setConnectorInterface(ConnectorInterface connectorInterface){
        dbConnector = connectorInterface;
    }

    public int createDB()throws SQLException{
        System.out.println("\nTearing down tables...");
        new DBCreator(dbConnector).tearDownTables();
        System.out.println("\nCreating tables...");
        int tablesCreated = new DBCreator(dbConnector).setUpDatabase();
        return tablesCreated;
    }

    public void publishToDB()throws SQLException{
        System.out.println("\nAdding Norway to countries...");
        Country norway = new Country();
        norway.setName("Norway");
        norway.setCapital(23456);
        norway.setCode("NOR");
        norway.setCode2("NO");
        norway.setContinents(Country.Continents.Europa);
        norway.setGnp(24399000);
        norway.setGnpOld(234567);
        norway.setGovernmentForm("Monarcy");
        norway.setHeadOfState("Erna Solberg");
        norway.setIndepYear(1905);
        norway.setLifeExpectancy(79);
        norway.setLocalName("Norge");
        norway.setPopulation(5000000);
        norway.setRegion("West");
        norway.setSurfaceArea(56789098);
        new DBPublisher(dbConnector).addCountry(norway);

        System.out.println("\nAdding Oslo to Cities...");
        City oslo = new City();
        oslo.setName("Oslo");
        oslo.setCountryCode(norway);
        oslo.setPopulation(500000);
        oslo.setDistrict("Oslo");
        new DBPublisher(dbConnector).addCity(oslo);

        System.out.println("\nAdding Bergen to Cities...");
        City bergen = new City("Bergen", norway, "Hordaland", 300000);
        new DBPublisher(dbConnector).addCity(bergen);

        System.out.println("\nAdding Trondheim to Cities...");
        City trondherim = new City("Trondheim", norway, "Sør-Trøndelag", 200000);
        new DBPublisher(dbConnector).addCity(trondherim);

        System.out.println("\nAdding som example data...");
        for (Country country : ExampleDataCreator.getCountries()) {
            new DBPublisher(dbConnector).addCountry(country);
        }

        for (City city : ExampleDataCreator.getCities()) {
            new DBPublisher(dbConnector).addCity(city);
        }

        for (CountryLanguage countryLanguage : ExampleDataCreator.getLanguages()) {
            new DBPublisher(dbConnector).addLanguage(countryLanguage);
        }


    }


    public void readFromDB()throws SQLException{
        System.out.println("\nGetting Oslo from City...");
        new DBReader(dbConnector).getCityByName("Oslo");
        System.out.println("\nGetting Norway from Countries...");
        new DBReader(dbConnector).getCountryByName("Norway");
        System.out.println("\nGetting all Countries...");
        new DBReader(dbConnector).getAllCountries();
        System.out.println("\nGetting all Cities...");
        new DBReader(dbConnector).getAllCities();
        System.out.println("\nGetting all CountryLanguages...");
        new DBReader(dbConnector).getAllCountyLanguages();

    }

    public void updateValueInDB()throws SQLException{
        System.out.println("\nUpdating Norway indep-year to 1814...");
        new DBUpdator(dbConnector).updateCountryIndepYear("Norway", 1814);
        new DBReader(dbConnector).getCountryByName("Norway");
    }

    public void deleteFromDB() throws SQLException{
        System.out.println("\nDeleting Oslo from Cities...");
        boolean cityGone = new DBDeleter(dbConnector).deleteCityByName("Oslo");
        if (cityGone) System.out.println("Oslo successfully deleted!");
        System.out.println("\nPrinting all cities...");
        new DBReader(dbConnector).getAllCities();

        System.out.println("\nDeleting country with code 'NOR' ");
        boolean countryGone = new DBDeleter(dbConnector).deleteCountryByCode("NOR");
        if (countryGone) System.out.println("Norway successfully deleted!");
    }
}
