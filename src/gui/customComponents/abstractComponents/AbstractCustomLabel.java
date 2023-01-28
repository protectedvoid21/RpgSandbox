package gui.customComponents.abstractComponents;

import gui.customComponents.IContentCustomUICmp;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.interfaces.ICustomUI;
import gui.margin.ComponentTextMarginManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Custom Label instance used in whole app, has methods which can menage the customLabelUI instance.
 */
public abstract class AbstractCustomLabel extends JLabel implements IContentCustomUICmp {
    private CustomLabelUI labelUI;

    public AbstractCustomLabel() {
        super("");
    }

    public AbstractCustomLabel(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
    }

    public void setUI(CustomLabelUI labelUI) {
        this.labelUI = labelUI;//kolejnosc mega wazna
        setBackground(getBackground());
        super.setUI(labelUI);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                labelUI.getCustomUI().setRelevantFont(getText());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(getFont());
        super.paintComponent(g);
    }

    public void setBackground(Color color) {
        if (labelUI != null) {
            labelUI.getCustomUI().setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }
        super.setBackground(color);
    }

    public ComponentTextMarginManager getMargin() {

        return labelUI == null ? null : labelUI.getMargin();
    }

    public void setMaximumFontSizeStatus(boolean status) {
        labelUI.getCustomUI().setFontMaximized(status);
        labelUI.getCustomUI().setRelevantFont(getText());
    }

    @Override
    public ICustomUI getCustomUI() {
        return labelUI.getCustomUI();
    }

    @Override
    public int getMaximumPossibleFontSize() {
        return getCustomUI().getRelevantFont(getText()).getSize();
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

    public abstract void setContent(String text);

    public abstract String getContent();

    @Override
    public void setText(String text) {
        super.setText(text);
        if (labelUI != null) {
            labelUI.getCustomUI().setRelevantFont(getText());
        }
    }
}
