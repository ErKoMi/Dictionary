package org.example.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner in;
    HashMap<String, MenuItem> items;
    boolean run;

    public Menu(){
        items = new HashMap<>();
        items.put("q", new MenuItem("Выход", () ->{
            run = false;
        }));
        in = new Scanner(System.in);
    }

    public void addItem(String command, MenuItem item){
        items.put(command, item);
    }

    public void start(){
        while (run){
            show();

            String command = in.nextLine();
            execute(command);
        }
    }

    void show(){
        for (Map.Entry item : items.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }

    void execute(String command){
        try {
            MenuItem item = items.get(command);
            item.execute();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Illegal menus item index!");
        }
    }
}
