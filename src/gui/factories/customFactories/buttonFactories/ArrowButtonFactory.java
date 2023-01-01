package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.IconLabel;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.customUIStyles.ThreeDUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBackgroundColorWraper;
import gui.customUI.wrapers.ImageBorderWraper;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ArrowButtonFactory extends ImageButtonFactory{

    private CustomButton helpCreatedMethod(CustomButton button, ActionListener listener){
        button.addActionListener(listener);
        button.setForeground(new Color(0x000000));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI(strategy,4, 10);
        var uiHelper = new ImageBorderWraper(ui, "src/gui/rightarrow.png","src/gui/leftarrow.png");
        if (isScaled) {
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
            uiHelper.setScalingStatus(true);
        }
        ui.addComponent(uiHelper);
        if (button instanceof IconButton){
            ui.addComponent(((IconButton) button).getIcon());
        }
        button.setBackground(new Color(0x52E13C));
        uiHelper.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(uiHelper);
        ui2.getCustomUI().setFontMaximized(true);
        button.setUI(ui2);

        return button;
    }
    @Override
    public CustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener );
    }

    @Override
    public CustomButton createIconPropButton(String text, ActionListener listener) {
        return helpCreatedMethod(new IconButton(text, true), listener);
    }

    @Override
    public CustomButton createIconStretchButton(String text, ActionListener listener) {
        return helpCreatedMethod(new IconButton(text), listener);
    }

    @Override
    public CustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener) {
        return createDisableIconButton(text1, text2, listener, true);
    }

    @Override
    public CustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener) {
        return createDisableIconButton(text, text2, listener, false);
    }

    private CustomButton createDisableIconButton(String text1, String text2, ActionListener listener, boolean proportionate){
        var but = helpCreatedMethod(new IconButton(text1, true), listener);
        if (text2 != null) {
            but.setDisabledIcon(new StretchIcon(text2, proportionate));
        }
        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }


}
