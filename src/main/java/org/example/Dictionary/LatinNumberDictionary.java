package org.example.Dictionary;

import java.util.regex.Pattern;

public class LatinNumberDictionary extends Dictionary {


    public LatinNumberDictionary(){
        super();
        keyIndex = 1;
        valuePattern = Pattern.compile("^\\d{5}$");
        keyPattern = Pattern.compile("^[a-z]{4}$");
    }
}
