package gui;

import gui.card.IOverallFactory;
import gui.card.WarHammerFactory;
import gui.menu.*;

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

        var c = f.createFullCard();

        var cmp = new ComponentPanelMenager<>(f.createFullCard().getPanel());
        cmp.addSpace(10);
        ramka.add(cmp);
        ramka.setVisible(true);
    }
}
