package org.example.Dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class Dictionary {
    HashMap<String, String> dictionary;
    protected int keyIndex;
    protected static final String splitter = "-";
    protected Pattern keyPattern;
    protected Pattern valuePattern;

    public Dictionary() {
        dictionary = new HashMap<>();
        keyIndex = 0;
    }

    public final void loadFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String string = reader.readLine(); string != null; string = reader.readLine()) {
                String[] pair = string.split(splitter);
                if (pair.length != 2) {
                    throw new IOException("Illegal row!");
                }

                try {
                    add(pair[keyIndex], pair[1 - keyIndex]);
                } catch (IllegalArgumentException e) {
                    throw new IOException(e.getMessage());
                }
            }
        }
    }

    public final void saveToFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist!");
        }

        try (FileWriter writer = new FileWriter(file)) {
            String string;
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                string = keyIndex == 0 ? entry.getKey() + splitter + entry.getValue() : entry.getValue() + splitter + entry.getKey() + System.lineSeparator();
                writer.write(string);
            }
        }
    }

    public void add(String key, String value) throws IllegalArgumentException {
        if (!checkKey(key)) {
            throw new IllegalArgumentException("Invalid key!");
        }

        if (!checkValue(value)) {
            throw new IllegalArgumentException("Invalid value!");
        }

        dictionary.put(key, value);
    }

    public String get(String key) {
        return dictionary.get(key);
    }

    protected boolean checkKey(String key) {
        return keyPattern.matcher(key).matches();
    }

    protected boolean checkValue(String value) {
        return valuePattern.matcher(value).matches();
    }
}
