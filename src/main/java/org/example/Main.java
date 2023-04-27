package org.example;

import org.example.Dictionary.Dictionary;
import org.example.Dictionary.LatinNumberDictionary;
import org.example.Dictionary.NumberLatinDictionary;
import org.example.menu.Menu;
import org.example.menu.MenuItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    static Dictionary dictionary;
    static String fileName = "";
    static String filePath;
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.addItem("path", new MenuItem("Введите относительный путь к словарю", () -> {
            fileName = in.nextLine();
            filePath = Path.of(fileName).toAbsolutePath().toString();
            File file = new File(filePath);

            try {
                file.createNewFile();
            } catch (IOException e) {
                out.println("Не удалось создать файл для словаря!");
            }
        },
        () -> fileName.equals("")));

        menu.addItem("num", new MenuItem("Выбрать словарь, где ключ - цифры", () ->{
            dictionary = new NumberLatinDictionary();
            loadDictionary();
        },
        () -> !fileName.equals("")));

        menu.addItem("latin", new MenuItem("Выбрать словарь, где ключ - латинские символы", () ->{
            dictionary = new LatinNumberDictionary();
            loadDictionary();
        },
        () -> !fileName.equals("")));

        menu.addItem("show", new MenuItem("Искать по ключу.", () -> {
            String key = in.nextLine();
            String value = dictionary.get(key);
            out.println(value);
        },
        () -> dictionary != null));

        menu.addItem("add", new MenuItem("Добавить значение.", () -> {
            out.println("Введите ключ значение через пробел:");
            String[] pair = in.nextLine().split(" ");
            if(pair.length != 2){
                out.println("Неверный формат ввода!");
                return;
            }

            try {
                dictionary.add(pair[0], pair[1]);
            }
            catch (Exception e){
                out.println(e.getMessage());
            }
            saveDictionary();
        },
        () -> dictionary != null));

        menu.addItem("q", new MenuItem("Выход", () ->{
            if(fileName.equals(""))
                menu.exit();
            else{
                fileName = "";
                dictionary = null;
            }
        },
        () -> true));

        menu.start();
    }

    private static void loadDictionary() {
        try {
            dictionary.loadFromFile(filePath);
        } catch (IOException e) {
            out.println("Не удалось загрузить словарь!");
        }
    }

    private static void saveDictionary(){
        if(dictionary != null){
            try {
                dictionary.saveToFile(filePath);
            } catch (IOException e) {
                out.println("Не удалось сохранить словарь!");
            }
        }
    }
}