package org.example.Dictionary;

import java.io.*;
import java.util.IllegalFormatException;
import java.util.regex.Pattern;

public class NumberLatinDictionary extends Dictionary {
    public NumberLatinDictionary(){
        super();
        keyIndex = 0;
        keyPattern = Pattern.compile("^\\d{5}$");
        valuePattern = Pattern.compile("^[a-z]{4}$");
    }
}
