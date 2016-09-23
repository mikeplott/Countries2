package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, ArrayList<Country>> theCountries = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String theAbbreviation = columns[0];
            String theName = columns[1];
            Country country = new Country(theAbbreviation, theName);
            //ArrayList<Country> allCountries = new ArrayList<>();
            CountriesWrapper.allCountries = new ArrayList<>();
            CountriesWrapper.allCountries.add(country);
            for (Country country1 : CountriesWrapper.allCountries) {
                ArrayList<Country> myCountries = theCountries.get(country1.countryName.substring(0,1));
                if (myCountries == null) {
                    myCountries = new ArrayList<>();
                    theCountries.put(country1.countryName.substring(0,1), myCountries);
                }
                myCountries.add(country1);
            }
//            for (String key : theCountries.keySet()) {
//                System.out.println(String.valueOf(theCountries));
//            }
        }
        System.out.println("Please enter a letter to display a list of countries.");
        String firstLetter = scanner.nextLine();
        for (int i = 0; i < theCountries.get(firstLetter).size(); i ++) {
            System.out.println(theCountries.get(firstLetter).get(i).abbreviation + "-" + theCountries.get(firstLetter).get(i).countryName);
        }
        main(args);
    }

    static void saveText(String x, ArrayList<Country> countries) {
        File textFile = new File(x + "_countries.txt");
        try {
            FileWriter textWriter = new FileWriter(textFile);
            textWriter.write(countries);
            textWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}