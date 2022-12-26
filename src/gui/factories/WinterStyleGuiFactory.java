package gui.factories;

import gui.customComponents.CustomButton;
import gui.customComponents.CustomLabel;
import gui.customUI.CustomButtonUI;
import gui.customUI.CustomLabelUI;
import gui.customUI.ICustomUI;
import gui.customUI.customUIStyles.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class WinterStyleGuiFactory extends GuiFactory {
    @Override
    public JLabel createLabel(String text) {
        var label = new CustomLabel(text);
        label.setForeground(new Color(0xE8E5E1));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        var uiHelper = new RoundedBorderUI();
        label.setBackground(new Color(0xA4170F));
        uiHelper.setAdditionaldColor(new Color(0x1C5003), ICustomUI.Index.FIRST);
        var ui = new CustomLabelUI(new GrowingBorderWraper(uiHelper));
        label.setUI(ui);
        ui.getMargin().set(0, 10, 0, 10);
        return label;
    }

    @Override
    public JButton createButton(String text, ActionListener listener) {
        var button = new CustomButton(text);
        button.addActionListener(listener);
        button.setForeground(new Color(0xE8E5E1));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        var ui = new ClickedStyleUI();
        RoundedBorderDecorator uiHelper = new ImageBorderWraper(ui,"src/gui/snowman.png");
        uiHelper = new GrowingBorderWraper(uiHelper);
        button.setBackground(new Color(0xBB3831));
        uiHelper.setAdditionaldColor(button.getBackground().darker(), ICustomUI.Index.FIRST);
        var ui2 = new CustomButtonUI(uiHelper);
        button.setUI(ui2);
        return button;
    }

    @Override
    public JTextComponent createTextField() {
        return null;
    }

}
