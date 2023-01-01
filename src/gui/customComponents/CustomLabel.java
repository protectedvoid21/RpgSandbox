package gui.customComponents;

import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.awt.*;

/**
 * Custom Label instance used in whole app, has methods which can menage the customLabelUI instance.
 */
public class CustomLabel extends JLabel implements ITextCustomUICmp {
    private CustomLabelUI labelUI;

    public CustomLabel() {
        super("");
    }

    public CustomLabel(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
    }

    public void setUI(CustomLabelUI labelUI) {
//        labelUI.getCustomUI()
        this.labelUI = labelUI;//kolejnosc mega wazna
        setBackground(getBackground());
        super.setUI(labelUI);
        repaint();
        revalidate();
//        this.labelUI = labelUI;
    }

    public void setBackground(Color color) {
        if (labelUI != null) {
            labelUI.getCustomUI().setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        if (labelUI != null) {
            labelUI.getCustomUI().setRelevantFont(getText());
        }
        super.paintComponent(g);
    }

    public ComponentTextMarginManager getMargin() {

        return labelUI == null ? null : labelUI.getMargin();
    }

    public void setMaximumFontSizeStatus(boolean status){
        labelUI.getCustomUI().setFontMaximized(status);
        labelUI.getCustomUI().setRelevantFont(getText());
    }

    @Override
    public ICustomUI getCustomUI() {
        return labelUI.getCustomUI();
    }

    @Override
    public int getMaximumPossibleFontSize() {
        return getCustomUI().getMaximumPossibleFont(getText()).getSize();
    }

    @Override
    public void setFont(int newFontSize) {
        var f = getFont();
        setFont(new Font(f.getName(), f.getStyle(), newFontSize));
    }

    @Override
    public boolean hasSharedSize() {
        return getCustomUI().hasSharedSize();
    }
}
