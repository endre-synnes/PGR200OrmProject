package com.endre.java.DTOs;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.sun.org.apache.bcel.internal.generic.POP;

@DatabaseTable(tableName = "city")
public class City {
    public static final String NAME_FIELD_NAME = "Name";
    public static final String COUNTRY_CODE_FIELD_NAME = "CountryCode";
    public static final String DISTRICT_FIELD_NAME = "District";
    public static final String POPULATION_FIELD_NAME = "Population";


    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
    private String name;

    @DatabaseField(columnName = COUNTRY_CODE_FIELD_NAME, canBeNull = false)
    private String countryCode;

    @DatabaseField(columnName = DISTRICT_FIELD_NAME, canBeNull = false)
    private String district;

    @DatabaseField(columnName = POPULATION_FIELD_NAME, canBeNull = false)
    private int population;

    public City(){}


    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (getId() != city.getId()) return false;
        if (getPopulation() != city.getPopulation()) return false;
        if (!getName().equals(city.getName())) return false;
        if (!getCountryCode().equals(city.getCountryCode())) return false;
        return getDistrict().equals(city.getDistrict());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCountryCode().hashCode();
        result = 31 * result + getDistrict().hashCode();
        result = 31 * result + getPopulation();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 86; i++) { builder.append("-"); }
        builder.append(String.format("\n|%-10s %-20s %-15s %-20s %-15s|\n", "ID", NAME_FIELD_NAME, COUNTRY_CODE_FIELD_NAME, DISTRICT_FIELD_NAME, POPULATION_FIELD_NAME));
        for (int i = 0; i < 86; i++) { builder.append("-"); }
        builder.append(String.format("\n|%-10s %-20s %-15s %-20s %-15s|\n", getId(), getName(), getCountryCode(), getDistrict(), getPopulation()));
        for (int i = 0; i < 86; i++) { builder.append("-"); }
        builder.append("\n");
        return builder.toString();
    }
}
