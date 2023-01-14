package gui;

/*
 * Copyright (c) 2000 David Flanagan.  All rights reserved.
 * This code is from the book Java Examples in a Nutshell, 2nd Edition.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, or to purchase the book (recommended),
 * visit http://www.davidflanagan.com/javaexamples2.
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An applet that displays the standard fonts and styles available in Java 1.1
 */
public class FontList extends JPanel {
    // The available font families
//    String[] families = { "Serif", // "TimesRoman" in Java 1.0
//            "SansSerif", // "Helvetica" in Java 1.0
//            "Monospaced" }; // "Courier" in Java 1.0
    String[] families2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] families = new String[80];


    // The available font styles and names for each one
    int[] styles = { Font.PLAIN };

    String[] stylenames = { "Plain" };
int x = 20;
    // Draw the applet.
    public void paint(Graphics g) {
        for (int i = 0; i < 80; i++) {
            families[i] = families2[i+140];
        }
        for (int f = 0; f < families.length; f++) { // for each family
            for (int s = 0; s < styles.length; s++) { // for each style
                Font font = new Font(families[f], styles[s], 18); // create font
                g.setFont(font); // set font
                String name = families[f] + " " + stylenames[s]; // create name
                g.drawString(name, 20, (f * 4 + s + 1) * 4); // display name
            }
        }
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new FontList());
        f.setSize(300,300);
        f.setVisible(true);
    }

}


