package org.example.Dictionary;

import java.util.HashMap;

public abstract class Dictionary {
    HashMap<String, String> dictionary;

    public Dictionary(){
        dictionary = new HashMap<>();
    }

    public abstract void loadFromFile(String fileName);
    public abstract void saveToFile(String fileName);
    public void add(String key, String value) throws IllegalArgumentException{
        if(check(key)){
            dictionary.put(key, value);
        }
        else {
            throw new IllegalArgumentException("Invalid key value!");
        }
    }
    public String get(String key){
        return dictionary.get(key);
    }

    protected abstract boolean check(String key);
}
