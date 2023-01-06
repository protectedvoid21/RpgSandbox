package gui.factories.customFactories.buttonFactories;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.CustomBooleanButton;
import gui.customComponents.CustomButton;
import gui.customComponents.CustomIconBooleanButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardDownPanelButtonFactory extends ButtonFactory{
    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener){
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI(strategy, 3, 10);
        if (button instanceof IconButton){
            ui.addComponent(((IconButton) button).getCustomIcon());
        }
        button.setBackground(new Color(0x682691));
        ui.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        ui.setFontMaximized(true);
        button.setUI(new CustomButtonUI(ui));
        return button;
    }
    @Override
    public AbstractCustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener);
    }

    @Override
    public AbstractCustomButton createIconPropButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text, true), listener);
        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }

    @Override
    public AbstractCustomButton createIconStretchButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text), listener);
        return but;
    }

    @Override
    public AbstractCustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener) {
        return null;
    }

    @Override
    public AbstractCustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener) {
        return null;
    }
    @Override
    public CustomBooleanButton createBooleanButton(String text1, String text2, boolean initialValue) {
        var but = helpCreatedMethod(new CustomBooleanButton(initialValue), null);
        ((CustomBooleanButton) but).setDoubleTextContent(text1, text2);
        return (CustomBooleanButton) but;
    }

    @Override
    public CustomIconBooleanButton createBooleanButtonWithIcons(String path1, String path2, boolean initialValue, boolean proportionate) {
        return null;
    }
}
