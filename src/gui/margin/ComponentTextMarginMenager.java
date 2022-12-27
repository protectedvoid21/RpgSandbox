package gui.margin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

public class ComponentTextMarginMenager {
    private JComponent component;

    public enum Side {LEFT, TOP, RIGHT, BOTTOM}

    public ComponentTextMarginMenager(JComponent component) {
        this.component = component;
    }

    public void set(int top, int left, int bottom, int right) {
        Border margin = new EmptyBorder(top, left, bottom, right);
        component.setBorder(margin);
    }

    public void set(Side side, int value) {
        var insets = component.getBorder().getBorderInsets(component);

        switch (side) {
            case TOP -> set(value, insets.left, insets.bottom, insets.right);
            case LEFT -> set(insets.top, value, insets.bottom, insets.right);
            case BOTTOM -> set(insets.top, insets.left, value, insets.right);
            case RIGHT -> set(insets.top, insets.left, insets.bottom, value);
        }
    }

}
