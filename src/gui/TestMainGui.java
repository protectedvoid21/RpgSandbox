package gui;

import gui.factories.*;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterGrowingBorderButtonFactory;
import gui.factories.customFactories.labelFactories.WinterDarkerBackgroundLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.menu.*;

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
        var menu = new CustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                ComponentsSeries.ComponentsDimension.VERTICAL);
        menu.addMainComponent(10);
        menu.addSpace(5, ComponentPanelMenager.Side.LEFT);
        menu.setBackground(Color.ORANGE);
        menu.addMiddleComponent(factory.createButton("WINTER TIME", null), 0, 20);
        menu.addMiddleComponent(factory.createTextArea(), 0, 20);
        menu.addMiddleComponent(factory.createTextField(), 0, 20);
        var m = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        m.addOption(factory.createIconLabel("src/gui/image2.png"), 10);
        m.addOption(factory.createIconLabel("src/gui/image2.png"), 10);
        menu.addMiddleComponent(m, 0, 40);
        menu.addMainComponent(5);
//        menu.getColumn(1).getOption(0).addSpace(10, ComponentMenager.Side.TOP);
        menu.addMiddleComponent(factory.createLabel("WINTER TIME"), 1, 1);
        menu.getMiddleComponent(1, 0).addSpace(20, ComponentPanelMenager.Side.LEFT);
        menu.addMiddleComponent(factory.createButton("HELLO WORLD", null), 1, 20);
        factory.setButtonFactory(new WinterGrowingBorderButtonFactory(0.6, 0.2));
        menu.getMiddleComponent(0, 3).addSpace(10, ComponentPanelMenager.Side.LEFT);
        menu.getMiddleComponent(0, 3).addSpace(20, ComponentPanelMenager.Side.TOP);
        menu.addMiddleComponent(factory.createButton("HELLO WORLD", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }), 0, 20);
        ramka.setVisible(true);
        menu.setBackground(Color.ORANGE);
        ramka.add(menu.getCmp());
    }
}
