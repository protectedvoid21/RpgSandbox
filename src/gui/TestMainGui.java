package gui;

import gui.Menu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class TestMainGui {
     public static void main(String[] args) {
         JFrame ramka = new JFrame();
         ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ramka.setSize(800, 800);
         ramka.getContentPane().setSize(800, 800);
         ramka.getContentPane().setBackground(Color.BLACK);


         MainMenu menu = new MainMenu(ramka.getContentPane());



         ramka.setVisible(true);

    }
}
