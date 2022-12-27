package gui;

import gui.factories.*;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterGrowingBorderButtonFactory;
import gui.factories.customFactories.labelFactories.WinterDarkerBackgroundLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class TestMainGui {
    public static void main(String[] args) throws MalformedURLException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        var factory = new GuiFactory();
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setLabelFactory(new WinterDarkerBackgroundLabelFactory());
        factory.setTextFactory(new TextFieldFactory());
        MainMenu menu = new MainMenu(ramka);
        menu.setBackground(Color.ORANGE);
        menu.addOption(factory.createButton("WINTER TIME", null));
        menu.addOption(factory.createTextArea());
        menu.addOption(factory.createTextField());
        menu.addOption(factory.createIconLabel("src/gui/image2.png"));
        menu.addOption(factory.createLabel("WINTER TIME"));
        menu.addOption(factory.createButton("HELLO WORLD", null));
        factory.setButtonFactory(new WinterGrowingBorderButtonFactory(0.6, 0.2));
        menu.addOption(factory.createButton("HELLO WORLD", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));

        menu.addVerticalPanels();
        menu.addMiddlePartVerticalPanels();
        ramka.setVisible(true);
    }
}
