package gui.factories;

import com.sun.tools.javac.Main;
import gui.Menu.MainMenu;

import javax.swing.*;
import java.util.HashMap;
import java.util.function.Function;

public abstract class MainMenuBuilder extends IMenuBuilder{
    private MainMenu menu;

    public MainMenuBuilder(){
        menu = new MainMenu();
    }

    @Override
    public void produceTitleComponent(String title) {

    }

    @Override
    public void produceRestComponents(HashMap<String, Function> buttonsMap) {
    }

    @Override
    public void produceRestComponent(String text, Function command) {

    }



    @Override
    public MainMenu getProduct() {
        return menu;
    }

    @Override
    public void reset() {
        menu = new MainMenu();
    }
}
