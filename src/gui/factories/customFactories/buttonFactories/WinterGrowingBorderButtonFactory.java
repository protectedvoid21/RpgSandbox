package gui.factories.customFactories.buttonFactories;

import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.baseCustomComponents.CustomButton;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customComponents.booleanComponents.MultiplyButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.customUI.wrapers.GrowingBorderWraper;
import gui.customUI.wrapers.ImageBorderWraper;
import gui.utils.StringAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Implementation of button factory which cretes specific kind of winter button (only for testing and to show
 * possibilities of using factories for creating new objects). It is created based on implementation of
 * ClickedStyleUI. Also this button has stars on its sides, scaling values can be set by client.
 */
public class WinterGrowingBorderButtonFactory extends ImageButtonFactory {
    public WinterGrowingBorderButtonFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }

    public WinterGrowingBorderButtonFactory() {
        super();
    }

    @Override
    public MultiplyButton createMultiplyButton() {
        return (MultiplyButton) helpCreatedMethod(new MultiplyButton(), null);
    }

    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener) {
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new RoundedBorderUI(strategy, (4), 10);
        var uiHelper = new ImageBorderWraper(ui, StringAdapter.getRelativePath("star.png"));
        if (isScaled) {
            uiHelper.setScalingStatus(true);
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
        }
        button.setBackground(new Color(0xBB3831));
        uiHelper.setAdditionaldColor(new Color(0x0A4B1D), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(new GrowingBorderWraper(new ChangingBorderColorWraper(uiHelper)));
        ui2.getCustomUI().setAdditionaldColor(new Color(0xDE9C0E), ICustomUI.Index.SECOND);
        button.setUI(ui2);
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
        var but = helpCreatedMethod(new IconButton(text1, true), listener);
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
    public CustomIconBooleanButton createBooleanButtonWithIcons(String path1, String path2, boolean initialValue,
                                                                boolean proportionate) {
        return null;
    }
}
