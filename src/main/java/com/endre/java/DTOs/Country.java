package com.endre.java.DTOs;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Country")
public class Country {

    public enum Continents {Asia, Europa, NorthAmerica, Africa, Oceania, Antarctica, SouthAmerica}

    public static final String CODE_FIELD_NAME = "Code";
    public static final String NAME_FIELD_NAME = "Name";
    public static final String CONTINENT_FIELD_NAME = "Continent";
    public static final String REGION_FIELD_NAME = "Region";
    public static final String SURFACE_AREA_FIELD_NAME = "SurfaceArea";
    public static final String INDEP_YEAR_FIELD_NAME = "IndepYear";
    public static final String POPULATION_FIELD_NAME = "Population";
    public static final String LIFE_EXPECTANCY_FIELD_NAME = "LifeExpectancy";
    public static final String GNP_FIELD_NAME = "GNP";
    public static final String GNP_OLD_FIELD_NAME = "GNPOld";
    public static final String LOCAL_NAME_FIELD_NAME = "LocalName";
    public static final String GOVERNMENT_FORM_FIELD_NAME = "GovernmentForm";
    public static final String HEAD_OF_STATE_FIELD_NAME = "HeadOfState";
    public static final String CAPITAL_FIELD_NAME = "Capital";
    public static final String CODE_2_FIELD_NAME = "Code2";



    @DatabaseField(columnName = CODE_FIELD_NAME, canBeNull = false, id = true)
    private String code;

    @DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
    private String name;

    @DatabaseField(columnName = CONTINENT_FIELD_NAME, canBeNull = false)
    private Continents continents;

    @DatabaseField(columnName = REGION_FIELD_NAME, canBeNull = false)
    private String region;

    @DatabaseField(columnName = SURFACE_AREA_FIELD_NAME, canBeNull = false)
    private float surfaceArea;

    @DatabaseField(columnName = INDEP_YEAR_FIELD_NAME)
    private int indepYear;

    @DatabaseField(columnName = POPULATION_FIELD_NAME, canBeNull = false)
    private int population;

    @DatabaseField(columnName = LIFE_EXPECTANCY_FIELD_NAME, canBeNull = false)
    private float lifeExpectancy;

    @DatabaseField(columnName = GNP_FIELD_NAME, canBeNull = false)
    private float gnp;

    @DatabaseField(columnName = GNP_OLD_FIELD_NAME)
    private float gnpOld;

    @DatabaseField(columnName = LOCAL_NAME_FIELD_NAME, canBeNull = false)
    private String localName;

    @DatabaseField(columnName = GOVERNMENT_FORM_FIELD_NAME, canBeNull = false)
    private String governmentForm;

    @DatabaseField(columnName = HEAD_OF_STATE_FIELD_NAME)
    private String headOfState;

    @DatabaseField(columnName = CAPITAL_FIELD_NAME)
    private int capital;

    @DatabaseField(columnName = CODE_2_FIELD_NAME, canBeNull = false)
    private String code2;

    public Country() {
    }

    public Country(String code, String name, Continents continents,
                   String region, float surfaceArea, int indepYear,
                   int population, float lifeExpectancy, float gnp,
                   float gnpOld, String localName, String governmentForm,
                   String headOfState, int capital, String code2) {
        this.code = code;
        this.name = name;
        this.continents = continents;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continents getContinents() {
        return continents;
    }

    public void setContinents(Continents continents) {
        this.continents = continents;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGnp() {
        return gnp;
    }

    public void setGnp(float gnp) {
        this.gnp = gnp;
    }

    public float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return getCode().equals(country.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 216; i++) { builder.append("-"); }
        builder.append(String.format("\n|%-10s %-20s %-25s %-10s %-15s %-10s %-10s %-15s %-10s %-10s %-10s %-20s %-15s %-10s %-10s|\n",
                CODE_FIELD_NAME, NAME_FIELD_NAME, CONTINENT_FIELD_NAME, REGION_FIELD_NAME, SURFACE_AREA_FIELD_NAME, INDEP_YEAR_FIELD_NAME,
                POPULATION_FIELD_NAME, LIFE_EXPECTANCY_FIELD_NAME, GNP_FIELD_NAME, GNP_OLD_FIELD_NAME, LOCAL_NAME_FIELD_NAME,
                GOVERNMENT_FORM_FIELD_NAME, HEAD_OF_STATE_FIELD_NAME, CAPITAL_FIELD_NAME, CODE_2_FIELD_NAME));
        for (int i = 0; i < 216; i++) { builder.append("-"); }
        builder.append(String.format("\n|%-10s %-20s %-25s %-10s %-15s %-10s %-10s %-15s %-10s %-10s %-10s %-20s %-15s %-10s %-10s|\n",
                getCode(), getName(), getContinents(), getRegion(), getSurfaceArea(), getIndepYear(), getPopulation(), getLifeExpectancy(),
                getGnp(), getGnpOld(), getLocalName(), getGovernmentForm(), getHeadOfState(), getCapital(), getCode2()));
        for (int i = 0; i < 216; i++) { builder.append("-"); }
        builder.append("\n");
        return builder.toString();
    }
}
