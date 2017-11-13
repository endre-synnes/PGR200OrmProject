package com.endre.java;

import com.endre.java.DTOs.City;
import com.endre.java.DTOs.Country;
import com.endre.java.DTOs.CountryLanguage;

import java.util.ArrayList;
import java.util.List;

public class ExampleDataCreator {

    public static List<City> getCities(){
        List<City> cities = new ArrayList<City>();
        cities.add(new City("Stocholm", getCountries().get(0), "Fadderullan", 805034));
        cities.add(new City("Goteborg", getCountries().get(0), "Uddevalla", 80500));
        return cities;
    }

    public static List<Country> getCountries(){
        List<Country> countries = new ArrayList<Country>();
        countries.add(new Country("SWE", "Sweeden", Country.Continents.Europa, "West",
                98765445, 1719, 12000000, 70, 987655678, 345654, "Sverige", "Monarcy",
                "Unknown", 345654, "SE"));
        countries.add(new Country("DEN", "Denmark", Country.Continents.Europa, "West",
                987645, 1649, 5000000, 78, 98765567, 34554, "Danmark", "Monarcy",
                "Unknown", 345654, "DE"));
        return countries;
    }

    public static List<CountryLanguage> getLanguages(){
        List<CountryLanguage> countryLanguages = new ArrayList<CountryLanguage>();
        countryLanguages.add(new CountryLanguage("NOR", "Norwegian", CountryLanguage.IsOfficial.T, 80));
        countryLanguages.add(new CountryLanguage("SWE", "Sweedish", CountryLanguage.IsOfficial.T, 95));
        countryLanguages.add(new CountryLanguage("DEN", "Dannish", CountryLanguage.IsOfficial.T, 85));
        return countryLanguages;

    }

}
