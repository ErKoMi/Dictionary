package org.example.Dictionary;

import java.io.*;
import java.util.IllegalFormatException;
import java.util.regex.Pattern;

public class NumberLatinDictionary extends Dictionary {
    public NumberLatinDictionary(){
        super();
        keyIndex = 0;
        valuePattern = Pattern.compile("^\\d{5}$");
        keyPattern = Pattern.compile("^[a-z]{4}$");
    }
}
