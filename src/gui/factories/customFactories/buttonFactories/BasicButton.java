package gui.factories.customFactories.buttonFactories;

import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.customComponents.baseCustomComponents.CustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BasicButton extends ButtonFactory {
    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener) {
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0x1C1515));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBackground(new Color(0x51813D));
        var ui = new RoundedBorderUI(strategy, 5, 10);
        ui.setAdditionaldColor(new Color(0x4D0202), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0xFF3333), ICustomUI.Index.SECOND);
        var x = new ChangingBorderColorWraper(ui);
        CustomButtonUI ui2 =  new CustomButtonUI(x);
        button.setUI(ui2);
        ui2.getCustomUI().setRespectionBorder(true);
        button.setMaximumFontSizeStatus(true);
        return button;
    }

    @Override
    public AbstractCustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener);
    }

    @Override
    public AbstractCustomButton createIconPropButton(String text, ActionListener listener) {
        return createDisabledIconPropButton(text, text, listener);
    }

    @Override
    public AbstractCustomButton createIconStretchButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text), listener);
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
        var but2 = new IconButton(text1, proportionate);
        but2.setHasSameDisabledIcon(true);
        var but = helpCreatedMethod( but2, listener);
        but.getCustomUI().getMargin().set(7,7,7,7);
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
        return (CustomIconBooleanButton) but;
    }
}
