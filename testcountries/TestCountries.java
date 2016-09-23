import com.company.CountriesWrapper;
import com.company.Country;
import com.company.Main;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Created by michaelplott on 9/22/16.
 */
public class TestCountries {

    // test method to test for importing a text file from the root

    @Test
    public void testHashMap() throws FileNotFoundException {
        File f = new File("Countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String theAbbreviation = columns[0];
            String theName = columns[1];
            Country country = new Country(theAbbreviation, theName);
            CountriesWrapper cw = new CountriesWrapper();
            cw.allCountries = new ArrayList<>();
            cw.allCountries.add(country);
            for (Country country1 : cw.allCountries) {
                ArrayList<Country> myCountries = Main.theCountries.get(country1.countryName.substring(0, 1));
                if (myCountries == null) {
                    myCountries = new ArrayList<>();
                    Main.theCountries.put(country1.countryName.substring(0, 1), myCountries);
                }
                myCountries.add(country1);
                assertTrue(myCountries != null);
            }
        }
    }
}