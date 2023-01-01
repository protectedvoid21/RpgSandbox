package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customComponents.CustomLabel;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.interfaces.IMovementComponent;
import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;
import gui.customUI.wrapers.ChangingBackgroundColorWraper;
import gui.customUI.wrapers.ImageBorderWraper;
import gui.factories.GuiFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Implementation of button factory which cretes specific kind of winter button (only for testing and to show
 * possibilities of using factories for creating new objects). It is created based on implementation of
 * ClickedStyleUI. Also this button has snowman on its sides, scaling values can be set by client.
 */
public class WinterClickedButtonFactory extends ImageButtonFactory {
    public WinterClickedButtonFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }

    public WinterClickedButtonFactory() {
        super();
    }

//    private ClickedStyleUI helpCreatedMethod2( button, GuiFactory.Size size){
//        var ui = new ClickedStyleUI((int)(4*GuiFactory.getSizeIndex(size)), 10);
//        ui.addComponent(button);
//        return ui;
//    }

    private CustomButton helpCreatedMethod(CustomButton button, ActionListener listener){
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBackground(new Color(0xBB3831));
        var ui = new ClickedStyleUI(strategy,10, 10);
        var uiHelper = new ImageBorderWraper(ui, "src/gui/snowman.png", "src/gui/star.png");
        if (isScaled) {
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
            uiHelper.setScalingStatus(true);
        }
        ui.addComponent(uiHelper);
        if (button instanceof IconButton){
            ui.addComponent(((IconButton)button).getIcon());
        }
        uiHelper.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0x0A4B1D), ICustomUI.Index.THIRD);
        var ui2 = new CustomButtonUI(uiHelper);
        button.setUI(ui2);
        return button;
    }
    @Override
    public CustomButton createNormalButton(String text, ActionListener listener) {
        return  helpCreatedMethod(new CustomButton(text), listener );
    }

    @Override
    public CustomButton createIconPropButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text, true), listener);
//        but.getCustomUI().setBackGroundTransparent(true);
        return but;
    }

    @Override
    public CustomButton createIconStretchButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text), listener);
        return but;
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
        but.getCustomUI().setBackGroundTransparent(false);
        return but;
    }
}
