package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.ClickedStyleUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBackgroundColorWraper;
import gui.customUI.wrapers.ImageBorderWraper;
import gui.factories.customFactories.buttonFactories.ButtonFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WinterClickedButtonFactory extends ImageButtonFactory {
    public WinterClickedButtonFactory(double scalingSizeValue, double scalingPositionValue) {
        super(scalingSizeValue, scalingPositionValue);
    }

    public WinterClickedButtonFactory(){super();}

    @Override
    public JButton create(String text, ActionListener listener) {
        var button = new CustomButton(text);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI(2, 10);
        var uiHelper = new ImageBorderWraper(ui, "src/gui/snowman.png");
        if (isScaled) {
            uiHelper.setScalingValue(scalingSizeValue, scalingPositionValue);
            uiHelper.setScalingStatus(true);
        }
        ui.addComponent(uiHelper);
        button.setBackground(new Color(0xBB3831));
        uiHelper.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(new ChangingBackgroundColorWraper(uiHelper));
        ui2.setAdditionaldColor(new Color(0x0A4B1D), ICustomUI.Index.THIRD);
        button.setUI(ui2);
        return button;
    }
}
