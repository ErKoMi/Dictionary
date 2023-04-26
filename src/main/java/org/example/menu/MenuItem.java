package org.example.menu;

public class MenuItem {
    String title;
    onSelectedMenuItemListener listener;

    public String getTitle() {
        return title;
    }

    public void select(){
        listener.onSelectedMenuItem();
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public interface onSelectedMenuItemListener{
        public void onSelectedMenuItem();
    }

    public MenuItem(String title, onSelectedMenuItemListener listener){
        this.listener = listener;
        this.title = title;
    }
}
