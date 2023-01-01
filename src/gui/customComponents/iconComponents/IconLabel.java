package gui.customComponents.iconComponents;

import gui.customComponents.CustomLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.TextAttribute;

public class IconLabel extends CustomLabel implements IIconComponent {
    private StretchIcon icon;

    public IconLabel(String iconPath) {
        this(iconPath, false);
    }

    public IconLabel(String iconPath, boolean prop) {
        super();
        setOpaque(false);
//        setBorder(new LineBorder(Color.RED, 5, true));//to fix
        icon = new StretchIcon( iconPath, prop);
        setIcon(icon);
    }

    public StretchIcon getIcon() {
        return icon;
    }

//    @Override
//    public void setText(String text) {
//        if (icon != null) {
//            icon.setText(text);
//        }
//    }
//
//    @Override
//    public void setFont(Font font) {
//        if (icon!=null){
//            icon.addAttribute(TextAttribute.FONT, font);
//        }
//    }
}
