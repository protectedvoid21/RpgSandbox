package gui.customComponents;

import gui.customComponents.IContentCustomUICmp;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Custom Button instance used in whole app, has methods which can menage the customButtonUI instance.
 */
public abstract class AbstractCustomButton extends JButton implements IContentCustomUICmp {
    private CustomButtonUI buttonUI;
    private Color backgroundColor;
    private Color secondColor;
    private boolean hasDisabledColor = false;

    public AbstractCustomButton() {
        this("");
    }

    public AbstractCustomButton(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
        backgroundColor = getBackground();

    }

    public void setUI(CustomButtonUI buttonUI) {
        this.buttonUI = buttonUI;
        setBackground(getBackground());
        super.setUI(buttonUI);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                buttonUI.getCustomUI().setRelevantFont(getText());
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                buttonUI.getCustomUI().setRelevantFont(getText());
            }
        });
    }

    public void setSecondDisabledColor(Color secondColor) {
        this.secondColor = secondColor;
    }

    public void setHasDisabledColor(boolean hasDisabledColor) {
        this.hasDisabledColor = hasDisabledColor;
    }

    @Override
    public void setEnabled(boolean b) {
//        super.setEnabled(b);
        if (hasDisabledColor) {
            if (!b) {
                setOnlySuperBackground(secondColor);
            } else {
                setOnlySuperBackground(backgroundColor);
            }
        }
        super.setEnabled(b);
    }

    private void helpBackgroundSetter(Color color) {
        if (buttonUI != null) {
            buttonUI.getCustomUI().setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }

        super.setBackground(color);
    }

    public void setBackground(Color color) {
        backgroundColor = color;
        helpBackgroundSetter(color);
    }

    public void setMaximumFontSizeStatus(boolean status) {
        buttonUI.getCustomUI().setFontMaximized(status);
        buttonUI.getCustomUI().setRelevantFont(getText());
    }

    @Override
    public ICustomUI getCustomUI() {
        return buttonUI != null ? buttonUI.getCustomUI() : null;
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
        if (buttonUI != null)
            buttonUI.getCustomUI().setRelevantFont(getText());
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);

        getCustomUI().setRelevantFont(getText());
    }

    private void setOnlySuperBackground(Color color) {
        helpBackgroundSetter(color);
    }

//    @Override
//    public void setBackground(Color color) {
//        super.setBackground(color);
//        backgroundColor = color;
//    }
}
