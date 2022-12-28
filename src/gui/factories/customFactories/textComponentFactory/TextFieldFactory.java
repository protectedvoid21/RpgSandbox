package gui.factories.customFactories.textComponentFactory;

import gui.customComponents.customTextComponents.CustomDocumentListener;
import gui.customComponents.customTextComponents.CustomTextArea;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customComponents.customTextComponents.CustomTextField;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.ChangingBorderColorWraper;
import gui.margin.ComponentTextMarginManager;

import java.awt.*;

/**
 * Implementation of TextFactory interface.
 * Provides the basic components for integrating the text with the client.
 */
public class TextFieldFactory implements ITextFactory {
    @Override//to fix
    public CustomTextComponent createTextField() {
        return initializeTextComponent(new CustomTextField());
    }

    @Override
    public CustomTextComponent createTextArea() {
        return initializeTextComponent(new CustomTextArea());
    }

    private CustomTextComponent initializeTextComponent(CustomTextComponent textField) {
        textField.getTextComponent().setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        var ui = new RoundedBorderUI();
        ui.setAdditionaldColor(new Color(0x670613), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0xEE3B51), ICustomUI.Index.SECOND);
        textField.setUI(new ChangingBorderColorWraper(ui));
        textField.setUI(ui);
        textField.setListener(new CustomDocumentListener(new Color(0xD08888)));
        textField.getMargin().set(ComponentTextMarginManager.Side.LEFT, 10);
        textField.getMargin().set(ComponentTextMarginManager.Side.RIGHT, 10);
        return textField;
    }
}
