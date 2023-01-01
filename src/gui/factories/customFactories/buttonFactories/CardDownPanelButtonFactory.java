package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.customUIStyles.NormalBorderUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.customUI.wrapers.GrowingBorderWraper;
import gui.customUI.wrapers.ImageBorderWraper;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CardDownPanelButtonFactory extends ButtonFactory{
    private CustomButton helpCreatedMethod(CustomButton button, ActionListener listener){
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI(strategy, 3, 10);
        if (button instanceof IconButton){
            ui.addComponent(((IconButton) button).getIcon());
        }
        button.setBackground(new Color(0x682691));
        ui.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        ui.setFontMaximized(true);
        button.setUI(new CustomButtonUI(ui));
        return button;
    }
    @Override
    public CustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener);
    }

    @Override
    public CustomButton createIconPropButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text, true), listener);
        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }

    @Override
    public CustomButton createIconStretchButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text), listener);
        return but;
    }

    @Override
    public CustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener) {
        return null;
    }

    @Override
    public CustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener) {
        return null;
    }
}
