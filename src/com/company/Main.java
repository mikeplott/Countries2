package com.company;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, ArrayList<Country>> theCountries = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Options.fileImport();
        Options.displaySelection();


    }
}