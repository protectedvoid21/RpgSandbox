package gui.customComponents.iconComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IconLabel extends JLabel implements IIconComponent {
    private StretchIcon icon;
    public IconLabel(String iconPath) {
        this(iconPath, false);
    }

    public IconLabel(String iconPath, boolean prop) {
        super();

        setBorder(new EmptyBorder(0, 0, 0, 0));
        icon = new StretchIcon(this, iconPath, prop);
        setIcon(icon);
    }

    public StretchIcon getIcon(){
        return icon;
    }

}
