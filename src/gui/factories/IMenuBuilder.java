package gui.factories;

import com.sun.tools.javac.Main;
import gui.Menu.MainMenu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public abstract class IMenuBuilder {
    protected MainMenu menu;

    public IMenuBuilder(){
        menu = new MainMenu();
    }
    public abstract void produceTitleComponent(String title);

    public abstract void produceRestComponents(HashMap<String, Function> buttonsMap);
    public abstract void produceRestComponent(String text, Function command);
    public abstract void produceRestComponents(ArrayList<String> buttonsMap);
    public abstract void produceRestComponent(String text);

    public void setSidePanels(){
        menu.addHorizontalPanels();
        menu.addMiddlePartVerticalPanels();
        menu.addVerticalPanels();
    }
    public MainMenu getProduct(){
        return menu;
    }
    public abstract void reset();
}
