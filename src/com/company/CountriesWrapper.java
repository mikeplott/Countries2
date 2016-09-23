package com.company;

import java.util.ArrayList;

/**
 * Created by michaelplott on 9/22/16.
 */
public class CountriesWrapper {
    public static ArrayList<Country> allCountries; //allCountries = new ArrayList<>();

    public CountriesWrapper() {

    }

    public CountriesWrapper(ArrayList<Country> allCountries) {
        this.allCountries = allCountries;
    }

    public ArrayList<Country> getAllCountries() {
        return allCountries;
    }
}
