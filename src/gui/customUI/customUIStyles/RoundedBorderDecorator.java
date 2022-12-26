package gui.customUI.customUIStyles;

import gui.customUI.CustomUI;
import gui.customUI.ICustomUI;

import javax.swing.*;
import java.awt.*;

public abstract class RoundedBorderDecorator implements ICustomUI {
    protected ICustomUI customUI;

    public RoundedBorderDecorator(ICustomUI ui){
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
        System.out.println(customUI.getBorderSize());
        return customUI.getBorderSize();
    }

    @Override
    public void paintBackground(Graphics g, JComponent c, int borderSize) {
        customUI.paintBackground(g, c, borderSize);
    }
}
