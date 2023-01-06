package gui.customComponents.iconComponents;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.TextAttribute;

public class IconLabel extends AbstractCustomLabel implements IIconComponent {
    private StretchIcon icon;

    public IconLabel(String iconPath) {
        this(iconPath, false);
    }

    @Override
    public void setContent(String text) {
        setContent(text, icon.isProportionate());
    }

    private void setContent(String text, boolean prop){
        icon = new StretchIcon( text, prop);
        setIcon(icon);
    }

    public IconLabel(String iconPath, boolean prop) {
        super();
        setOpaque(false);
//        setBorder(new LineBorder(Color.RED, 5, true));//to fix
        setContent(iconPath, prop);
    }

    public StretchIcon getCustomIcon() {
        return icon;
    }

    @Override
    public String getContent() {
        return icon.getPath();
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
