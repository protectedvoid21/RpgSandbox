package gui.customComponents.iconComponents;

import gui.customComponents.CustomButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IconButton extends CustomButton implements IIconComponent {

    private StretchIcon icon;
    public IconButton(String iconPath) {
        this(iconPath, false);
    }

    public IconButton(String iconPath, boolean prop){
        super();
//        setContentAreaFilled(false);
//        setFocusPainted(false);
//        setBorder(new EmptyBorder(0, 0, 0, 0));
        icon = new StretchIcon( iconPath, prop);
        setIcon(icon);

    }

    public StretchIcon getIcon(){
        return icon;
    }
}
