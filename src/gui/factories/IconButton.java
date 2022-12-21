package gui.factories;

import gui.customIcon.StretchIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IconButton extends JButton {
    public IconButton(String iconPath) {
        super();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
        StretchIcon icon = new StretchIcon(iconPath);
        setIcon(icon);
    }
}
