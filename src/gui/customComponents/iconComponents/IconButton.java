package gui.customComponents.iconComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class IconButton extends JButton  implements IIconComponent {

    private StretchIcon icon;
    public IconButton(String iconPath) {
        this(iconPath, false);
    }

    public IconButton(String iconPath, boolean prop){
        super();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
        icon = new StretchIcon(this, iconPath, prop);
        setIcon(icon);

    }

    public StretchIcon getIcon(){
        return icon;
    }
}
