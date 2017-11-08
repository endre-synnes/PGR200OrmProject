package com.endre.java.DTOs;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Countrylanguage")
public class Countrylanguage {

    public enum IsOfficial{
        T, F
    }

    public static final String COUNTRY_CODE_FIELD_NAME = "CountryCode";
    public static final String LANGUAGE_FIELD_NAME = "Language";
    public static final String IS_OFFICIAL_FIELD_NAME = "IsOfficial";
    public static final String PERCENTAGE_FIELD_NAME = "Percentage";

    @DatabaseField(columnName = COUNTRY_CODE_FIELD_NAME, canBeNull = false)
    private String countryCOde;

    @DatabaseField(columnName = LANGUAGE_FIELD_NAME, canBeNull = false)
    private String language;

    @DatabaseField(columnName = IS_OFFICIAL_FIELD_NAME, canBeNull = false)
    private IsOfficial isOfficial;

    @DatabaseField(columnName = PERCENTAGE_FIELD_NAME, canBeNull = false)
    private float Percentage;

    public Countrylanguage() {
    }

    public Countrylanguage(String countryCOde, String language, IsOfficial isOfficial, float percentage) {
        this.countryCOde = countryCOde;
        this.language = language;
        this.isOfficial = isOfficial;
        Percentage = percentage;
    }

    public String getCountryCOde() {
        return countryCOde;
    }

    public void setCountryCOde(String countryCOde) {
        this.countryCOde = countryCOde;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public IsOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(IsOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float percentage) {
        Percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countrylanguage that = (Countrylanguage) o;

        if (getCountryCOde() != null ? !getCountryCOde().equals(that.getCountryCOde()) : that.getCountryCOde() != null)
            return false;
        return getLanguage() != null ? getLanguage().equals(that.getLanguage()) : that.getLanguage() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountryCOde() != null ? getCountryCOde().hashCode() : 0;
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        return result;
    }
}
