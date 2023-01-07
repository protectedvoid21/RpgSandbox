package gui.factories.customFactories.buttonFactories;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.CustomButton;
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

public class ArrowButtonFactory extends ImageButtonFactory {

    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener) {
        button.addActionListener(listener);
        button.setForeground(new Color(0x000000));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI(strategy, 4, 10);
        var uiHelper = new ImageBorderWraper(ui, "src/gui/rightarrow.png", "src/gui/leftarrow.png");
        if (isScaled) {
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
            uiHelper.setScalingStatus(true);
        }
        ui.addComponent(uiHelper);
        if (button instanceof IconButton) {
            ui.addComponent(((IconButton) button).getCustomIcon());
        }
        button.setBackground(new Color(0x52E13C));
        uiHelper.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(uiHelper);
        ui2.getCustomUI().setFontMaximized(true);
        button.setUI(ui2);

        return button;
    }

    @Override
    public AbstractCustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener);
    }

    @Override
    public AbstractCustomButton createIconPropButton(String text, ActionListener listener) {
        return helpCreatedMethod(new IconButton(text, true), listener);
    }

    @Override
    public AbstractCustomButton createIconStretchButton(String text, ActionListener listener) {
        return helpCreatedMethod(new IconButton(text), listener);
    }

    @Override
    public AbstractCustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener) {
        return createDisableIconButton(text1, text2, listener, true);
    }

    @Override
    public AbstractCustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener) {
        return createDisableIconButton(text, text2, listener, false);
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

    private AbstractCustomButton createDisableIconButton(String text1, String text2, ActionListener listener,
                                                         boolean proportionate) {
        var but = helpCreatedMethod(new IconButton(text1, proportionate), listener);
        if (text2 != null) {
            but.setDisabledIcon(new StretchIcon(text2, proportionate));
        }
        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }


}
