package gui;

import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.menu.*;
import gui.menuViews.MenuView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestMainGui {
    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();


        var cmp = new ComponentPanelMenager<>(f.createCreatorCard(Card.CreatorTypes.WEAPONS).getPanel());
        var main = f.createMenuView();
//        cmp.addSpace(10);
        ramka.add(main.getPanel());
        ramka.setVisible(true);
    }
}
