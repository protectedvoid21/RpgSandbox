package gui.customUI.wrapers;

import gui.card.SharedCmpsFont;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.awt.*;

/**Abstract class used for creating new Wrappers.*/
public abstract class BorderDecorator implements ICustomUI {
    protected ICustomUI customUI;

    @Override
    public boolean hasSharedSize() {
        return customUI.hasSharedSize();
    }

    @Override
    public void setSharedComponentSize(SharedCmpsFont cmp) {
        customUI.setSharedComponentSize(cmp);
    }

    @Override
    public Font getMaximumPossibleFont(String labelText) {
        return customUI.getMaximumPossibleFont(labelText);
    }

    public BorderDecorator(ICustomUI ui){
        customUI = ui;
    }


    @Override
    public void installUI(JComponent c) {
        customUI.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c){
        customUI.paint(g, c);
    }

    @Override
    public void setAdditionaldColor(Color color, Index index) {
        customUI.setAdditionaldColor(color, index);
    }

    @Override
    public Color getAdditionalColor(Index index) {
        return customUI.getAdditionalColor(index);
    }

    @Override
    public int getBorderSize() {
        return customUI.getBorderSize();
    }

    @Override
    public void paintBackground(Graphics g, JComponent c, int borderSize) {
        customUI.paintBackground(g, c, borderSize);
    }

    @Override
    public void setRelevantFont(String text) {
        customUI.setRelevantFont(text);
    }


    @Override
    public void setFontMaximized(boolean fontMaximized) {
        customUI.setFontMaximized(fontMaximized);
    }

    @Override
    public void setBackGroundTransparent(boolean newStatus) {
        customUI.setBackGroundTransparent(newStatus);
    }

    @Override
    public boolean isBackgroundTransparent() {
        return customUI.isBackgroundTransparent();
    }

//    @Override
//    public double conv(JComponent c, int offSetValue) {
//        return customUI.convertBorderSizeToValue(c, offSetValue);
//    }


    @Override
    public double convertSideBorderSizeToValue(JComponent c, int offSetValue) {
        return customUI.convertSideBorderSizeToValue(c, offSetValue);
    }
    @Override
    public double convertTopBorderSizeToValue(JComponent c, int offSetValue) {
        return customUI.convertTopBorderSizeToValue(c, offSetValue);
    }

    @Override
    public void setRespectionBorder(boolean value) {
        customUI.setRespectionBorder(value);
    }

    @Override
    public boolean getMarginRespection() {
        return customUI.getMarginRespection();
    }

    @Override
    public ComponentTextMarginManager getMargin() {
        return customUI.getMargin();
    }
}
