package gui.factories.customFactories.buttonFactories;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.CustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.customUI.wrapers.DarkerHoverComponentWraper;
import gui.customUI.wrapers.ImageBorderWraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuButtonsFactory extends ImageButtonFactory {
    private String pathLeft = "";
    private String pathRight ="";

    public MenuButtonsFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }

    public MenuButtonsFactory() {
        super();
    }

//    private ClickedStyleUI helpCreatedMethod2( button, GuiFactory.Size size){
//        var ui = new ClickedStyleUI((int)(4*GuiFactory.getSizeIndex(size)), 10);
//        ui.addComponent(button);
//        return ui;
//    }

    private AbstractCustomButton helpCreatedMethod(AbstractCustomButton button, ActionListener listener) {
        button.setFont(font);
        button.addActionListener(listener);
        button.setForeground(new Color(0x1C1515));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBackground(new Color(0x51813D));
        var ui = new RoundedBorderUI(strategy, 7, 10);
        ui.setAdditionaldColor(new Color(0x4D0202), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0xFF3333), ICustomUI.Index.SECOND);
        var x = new ChangingBorderColorWraper(new DarkerHoverComponentWraper(ui));
//        var uiHelper = new ImageBorderWraper(ui, "src/gui/swo.png", "src/gui/swo.png");
        CustomButtonUI ui2 = null;
        if (!pathLeft.isEmpty() && !pathRight.isEmpty()) {
            var uiHelper = new ImageBorderWraper(x, pathLeft, pathRight);
            if (isScaled) {
                uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
                uiHelper.setScalingStatus(true);
            }
            ui2 = new CustomButtonUI(uiHelper);
        } else {
            ui2 = new CustomButtonUI(x);
        }

//        var uiHelper = new ImageBorderWraper(ui, "src/gui/swo.png", "src/gui/swo.png");
//        if (isScaled) {
//            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
//            uiHelper.setScalingStatus(true);
//        }
//        uiHelper.setAdditionaldColor(new Color(0x4D0202), ICustomUI.Index.FIRST);
//        uiHelper.setAdditionaldColor(new Color(0xFF3333), ICustomUI.Index.SECOND);
//        ui.setAdditionaldColor(new Color(0x0A4B1D), ICustomUI.Index.THIRD);
//        var x = new ChangingBorderColorWraper(new DarkerHoverComponentWraper(ui));

//        var ui2 = new CustomButtonUI(x);
        button.setUI(ui2);
        button.setMaximumFontSizeStatus(true);
        button.getCustomUI().getMargin().set(10, 30, 10, 30);
        ui2.getCustomUI().setRespectionBorder(true);
        return button;
    }

    @Override
    public AbstractCustomButton createNormalButton(String text, ActionListener listener) {
        return helpCreatedMethod(new CustomButton(text), listener);
    }

    @Override
    public AbstractCustomButton createIconPropButton(String text, ActionListener listener) {
        var but = helpCreatedMethod(new IconButton(text, true), listener);
        but.getCustomUI().getMargin().set(10,10,10,10);
//        but.getCustomUI().setRespectionBorder(false);
//        but.getCustomUI().setBackGroundTransparent(true);
        return but;
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
    public void setPaths(String pathLeft, String pathRight) {
        this.pathLeft = pathLeft;
        this.pathRight = pathRight;
    }
}