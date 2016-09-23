import com.company.Country;
import com.company.Options;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Created by michaelplott on 9/22/16.
 */
public class testSave {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void testSaveAndLoad() {
        System.out.println("Please enter a country abbreviation");
        String abb = scanner.nextLine();
        System.out.println("Please enter the country name");
        String name = scanner.nextLine();
        Country country = new Country(abb, name);
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(country);
        System.out.println("Please enter country's first letter of their name");
        String firstLetter = scanner.nextLine();
        Options.saveText(firstLetter, countries);

    }
}
