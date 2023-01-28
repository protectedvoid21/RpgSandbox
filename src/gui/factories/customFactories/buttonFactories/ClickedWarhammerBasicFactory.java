package gui.factories.customFactories.buttonFactories;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.CustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ImageBorderWraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClickedWarhammerBasicFactory extends ButtonFactory{


    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener) {
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0x000000));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBackground(new Color(0x1D7A2E));
        var ui = new ClickedStyleUI(strategy, 7, 10);
        ui.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        if (button instanceof IconButton) {
            ui.addComponent(((IconButton) button).getCustomIcon());
        }
        var ui2 = new CustomButtonUI(ui);
        button.setUI(ui2);
        button.setMaximumFontSizeStatus(true);
        ui2.getCustomUI().setRespectionBorder(true);
        return button;
    }

    @Override
    public AbstractCustomButton createNormalButton(String text, ActionListener listener) {
        var but =  helpCreatedMethod(new CustomButton(text), listener);
        but.getCustomUI().getMargin().set(15, 15, 15, 15);
        return but;
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
        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }

    @Override
    public AbstractCustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener) {
        return createDisableIconButton(text1, text2, listener, true);
    }

    @Override
    public AbstractCustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener) {
        return createDisableIconButton(text, text2, listener, false);
    }

    private AbstractCustomButton createDisableIconButton(String text1, String text2, ActionListener listener,
                                                         boolean proportionate) {
        var but = helpCreatedMethod(new IconButton(text1, proportionate), listener);
        if (text2 != null) {
            but.setDisabledIcon(new StretchIcon(text2, proportionate));
        }
        but.getCustomUI().setBackGroundTransparent(false);
        return but;
    }

    @Override
    public CustomBooleanButton createBooleanButton(String text1, String text2, boolean initialValue) {
        var but = helpCreatedMethod(new CustomBooleanButton(initialValue), null);
        ((CustomBooleanButton) but).setDoubleTextContent(text1, text2);
        return (CustomBooleanButton) but;
    }

    @Override
    public CustomIconBooleanButton createBooleanButtonWithIcons(String path1, String path2, boolean initialValue, boolean proportionate) {
        var but = helpCreatedMethod(new CustomIconBooleanButton(path1, path2, initialValue, proportionate), null);
//        ((CustomIconBooleanButton) but).setDoubleTextContent(path1, path2);
        return (CustomIconBooleanButton) but;
    }
}
