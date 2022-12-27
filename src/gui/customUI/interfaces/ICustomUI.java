package gui.customUI.interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public interface ICustomUI {
    public enum Index {BASE_BACKGROUND, FIRST, SECOND, THIRD}

    void installUI(JComponent c);

    void paint(Graphics g, JComponent c);

    void setAdditionaldColor(Color color, Index index);

    Color getAdditionalColor(Index index);

    int getBorderSize();

    void paintBackground(Graphics g, JComponent c, int borderSize);

}
