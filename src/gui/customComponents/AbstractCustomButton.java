package gui.customComponents;

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

    public AbstractCustomButton() {
        super("");
    }

    public AbstractCustomButton(String s) {
        super(s);
        setPreferredSize(new Dimension(20, 20));
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

    public void setBackground(Color color) {
        if (buttonUI != null) {
            buttonUI.getCustomUI().setAdditionaldColor(color, ICustomUI.Index.BASE_BACKGROUND);
        }

        super.setBackground(color);
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
}
