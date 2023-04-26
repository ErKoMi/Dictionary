package org.example.menu;

import java.util.ArrayList;

public class Menu {
    ArrayList<MenuItem> items;

    public void addItem(MenuItem item){
        items.add(item);
    }

    public void show(){
        for (int i = 0; i < items.size(); i++){
            System.out.println(i + " " + items.get(i));
        }
    }

    public void execute(int index){
        try {
            MenuItem item = items.get(index);
            item.select();
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Illegal menus item index!");
        }
    }
}
