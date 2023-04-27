package org.example.menu;

public class MenuItem {
    String title;
    onSelectedMenuItemListener listener;

    public void execute(){
        listener.onSelectedMenuItem();
    }

    @Override
    public String toString() {
        return title;
    }

    public interface onSelectedMenuItemListener{
        public void onSelectedMenuItem();
    }

    public MenuItem(String title, onSelectedMenuItemListener listener){
        this.listener = listener;
        this.title = title;
    }
}
