package gui.factories;

import gui.customIcon.StretchIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.font.TextAttribute;

public class IconLabel extends JLabel implements IIconComponent{
    private StretchIcon icon;
    public IconLabel(String iconPath) {
        super();

        setBorder(new EmptyBorder(0, 0, 0, 0));
        icon = new StretchIcon(this, iconPath);
        setIcon(icon);
    }

    public StretchIcon getIcon(){
        return icon;
    }

}
