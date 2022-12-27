package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customUI.componentsUIs.CustomButtonUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.customUI.wrapers.GrowingBorderWraper;
import gui.customUI.wrapers.ImageBorderWraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WinterGrowingBorderButtonFactory implements ButtonFactory {
    @Override
    public JButton create(String text, ActionListener listener) {
        var button = new CustomButton(text);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new RoundedBorderUI();
        var uiHelper = new ImageBorderWraper(ui,"src/gui/star.png");
        uiHelper.setScalingStatus(true);
        uiHelper.setScalingValue(0.5);
        button.setBackground(new Color(0xBB3831));
        uiHelper.setAdditionaldColor(new Color(0x0A4B1D), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(new GrowingBorderWraper(new ChangingBorderColorWraper(uiHelper)));
        ui2.setAdditionaldColor(new Color(0xDE9C0E), ICustomUI.Index.SECOND);
        button.setUI(ui2);
        return button;
    }
}
