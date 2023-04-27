package org.example.menu;

public class MenuItem {
    String title;
    onExecuteMenuItemListener listener;
    onCanExecuteMenuItemListener canExecuteListener;

    public void execute() {
        if(canExecuteListener != null && listener != null && canExecuteListener.onCanExecute())
            listener.onExecuteMenuItem();
    }

    public boolean canExecute(){
        if(canExecuteListener != null){
            return canExecuteListener.onCanExecute();
        }

        return false;
    }

    @Override
    public String toString() {
        return title;
    }

    public interface onExecuteMenuItemListener {
        void onExecuteMenuItem();
    }

    public interface onCanExecuteMenuItemListener {
        boolean onCanExecute();
    }

    public MenuItem(String title, onExecuteMenuItemListener listener, onCanExecuteMenuItemListener canExecuteListener){
        this.listener = listener;
        this.canExecuteListener = canExecuteListener;
        this.title = title;
    }
}
