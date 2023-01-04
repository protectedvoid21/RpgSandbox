package gui.customUI.interfaces;

import gui.card.SharedCmpsFont;
import gui.margin.ComponentTextMarginManager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public interface ICustomUI {
    public enum Index {BASE_BACKGROUND, FIRST, SECOND, THIRD, FOURTH, FIFTH}

    void installUI(JComponent c);

    void paint(Graphics g, JComponent c);

    void setAdditionaldColor(Color color, Index index);

    Color getAdditionalColor(Index index);

    int getBorderSize();

    double convertTopBorderSizeToValue(JComponent c, int offSetValue);

    double convertSideBorderSizeToValue(JComponent c, int offSetValue);

    void paintBackground(Graphics g, JComponent c, int borderSize);

    void setRelevantFont(String text);

    boolean hasSharedSize();

    void setSharedComponentSize(SharedCmpsFont cmp);

    //    Font getMaximumPossibleFontByComponent(String labelText);
    Font getRelevantFont(String labelText);

    ComponentTextMarginManager getCurrentActivatedMargin();

    boolean isFontMaximized();

    boolean isBackgroundTransparent();

    void setBackGroundTransparent(boolean newStatus);

    void setFontMaximized(boolean fontMaximized);

    void setRespectionBorder(boolean value);

    ComponentTextMarginManager getMargin();

    boolean getMarginRespection();

    public void setFontRelevantToHeight(boolean val);
//    public void setFontRelevantToHeightValue(double value);
//    public Font getMaximumPossibleFontRelevantToHeight(String text);

    public boolean isFontRelevantToHeight();
}
