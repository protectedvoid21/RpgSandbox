package gui.customUI.wrapers;

import gui.card.SharedCmpsFont;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class used for creating new Wrappers.
 */
public abstract class BorderDecorator implements ICustomUI {
    protected ICustomUI customUI;

    protected boolean isOn() {
        return true;
    }

    @Override
    public void setOffSet(int value) {
        customUI.setOffSet(value);
    }

    @Override
    public void calculateMargins() {
        customUI.calculateMargins();
    }

    @Override
    public boolean hasSharedSize() {
        return customUI.hasSharedSize();
    }

    @Override
    public void setSharedComponentSize(SharedCmpsFont cmp) {
        customUI.setSharedComponentSize(cmp);
    }


    public BorderDecorator(ICustomUI ui) {
        customUI = ui;
    }


    @Override
    public void changeBorderStrategy(IBorderStrategy newStrategy) {
        customUI.changeBorderStrategy(newStrategy);
    }

    @Override
    public void installUI(JComponent c) {
        customUI.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
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


    @Override
    public double convertSideBorderSizeToValue(JComponent c, int offSetValue) {
        return customUI.convertSideBorderSizeToValue(c, offSetValue);
    }

    @Override
    public double convertTopBorderSizeToValue(JComponent c, int offSetValue) {
        return customUI.convertTopBorderSizeToValue(c, offSetValue);
    }

    @Override
    public ComponentTextMarginManager getCurrentActivatedMargin() {
        return customUI.getCurrentActivatedMargin();
    }


    @Override
    public Font getRelevantFont(String labelText) {
        return customUI.getRelevantFont(labelText);
    }

    @Override
    public void setFontRelevantToHeight(boolean val) {
        customUI.setFontRelevantToHeight(val);
    }

    @Override
    public boolean isFontRelevantToHeight() {
        return customUI.isFontRelevantToHeight();
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

    @Override
    public boolean isFontMaximized() {
        return customUI.isFontMaximized();
    }
}
