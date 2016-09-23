package com.company;

/**
 * Created by michaelplott on 9/22/16.
 */
public class Country {
    String abbreviation;
    public String countryName;

    public Country(String abbreviation, String countryName) {
        this.abbreviation = abbreviation;
        this.countryName = countryName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "abbreviation='" + abbreviation + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
