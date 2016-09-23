package com.company;

import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by michaelplott on 9/22/16.
 */
public class Options {

    // imports and parses the Countries.txt file into a hashmap called theCountries
    static void fileImport() throws FileNotFoundException {
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String theAbbreviation = columns[0];
            String theName = columns[1];
            Country country = new Country(theAbbreviation, theName);
            CountriesWrapper.allCountries = new ArrayList<>();
            CountriesWrapper.allCountries.add(country);
            //CountriesWrapper allCountries = new CountriesWrapper(CountriesWrapper.allCountries);
            for (Country country1 : CountriesWrapper.allCountries) {
                ArrayList<Country> myCountries = Main.theCountries.get(country1.countryName.substring(0,1));
                if (myCountries == null) {
                    myCountries = new ArrayList<>();
                    Main.theCountries.put(country1.countryName.substring(0,1), myCountries);
                }
                myCountries.add(country1);
            }
        }
    }
    // prompts the user for a letter and displays a list of countries beginning with that letter and saves that list to a text file
    static void displaySelection(CountriesWrapper countriesWrapper) throws Exception {
        System.out.println("Please enter a letter to display a list of countries.");
        String firstLetter = Main.scanner.nextLine();
            if (firstLetter.equals("")) {
                displaySelection(countriesWrapper);
            }
            else if (firstLetter.equalsIgnoreCase("x")) {
                System.out.println("No country with x");
                displaySelection(countriesWrapper);
            }
            else if (firstLetter.length() > 1) {
                throw new Exception("LETTER NOT LETTERS!");
            }
            for (int i = 0; i < Main.theCountries.get(firstLetter).size(); i++) {
                System.out.println(Main.theCountries.get(firstLetter).get(i).abbreviation + "-" + Main.theCountries.get(firstLetter).get(i).countryName);
            }
            saveText(firstLetter, Main.theCountries.get(firstLetter));
            saveJson(firstLetter, countriesWrapper);
            displaySelection(countriesWrapper);
    }
    // save method and logic to write console outputs to text files
    public static void saveText(String x, ArrayList<Country> countries) {
        File textFile = new File(x + "_countries.txt");
        try {
            FileWriter textWriter = new FileWriter(textFile);
            textWriter.write(String.valueOf(countries));
            textWriter.close();
            System.out.println("File saved Successfully!");
        } catch (IOException e) {
            System.out.println("File could not be saved.");
        }
    }
    // json save method and logic to write text outputs to json files
    public static void saveJson(String x, CountriesWrapper countriesWrapper) throws IOException {
        File jsonFile = new File(x + ".json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(countriesWrapper);
        FileWriter jsonWriter = new FileWriter(jsonFile);
        jsonWriter.write(json);
        jsonWriter.close();
    }
}

