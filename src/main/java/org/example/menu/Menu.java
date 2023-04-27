package org.example.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner in;
    HashMap<String, MenuItem> items;
    boolean run;

    public Menu(){
        items = new HashMap<>();
        in = new Scanner(System.in);
    }

    public void addItem(String command, MenuItem item){
        items.put(command, item);
    }

    public void start(){
        run  = true;
        while (run){
            show();

            String command = in.nextLine().trim();
            execute(command);
        }
    }

    public void exit(){
        run = false;
    }

    void show() {
        System.out.println(ANSI_YELLOW + "-------------------------------------------------" + ANSI_RESET);
        for (Map.Entry item : items.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList()) {
            if(((MenuItem)item.getValue()).canExecute())
                System.out.println(ANSI_GREEN + item.getKey() + ANSI_RESET + " - " + item.getValue());
        }
        System.out.println(ANSI_YELLOW + "-------------------------------------------------" + ANSI_RESET);
    }

    void execute(String command){
        MenuItem item = items.get(command);
        if(item != null)
            item.execute();
        else
            System.out.println(ANSI_RED + "Illegal command!" + ANSI_RESET);
    }
}
