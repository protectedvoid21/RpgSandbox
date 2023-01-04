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
public class TextFieldFactory extends TextFactory {
    @Override//to fix
    public CustomTextComponent createTextField() {
        return initializeTextComponent(new CustomTextField());
    }

    @Override
    public CustomTextComponent createTextArea() {
        return initializeTextComponent(new CustomTextArea());
    }

    private CustomTextComponent initializeTextComponent(CustomTextComponent textField) {
//        textField.setFont(new Font("Helvetica", Font.ITALIC, 14));
        textField.getTextComponent().setForeground(Color.GRAY);
        textField.setBackground(Color.BLUE);
        var ui = new RoundedBorderUI(strategy);
        ui.setAdditionaldColor(new Color(0x670613), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0xEE3B51), ICustomUI.Index.SECOND);
        textField.setUI(new ChangingBorderColorWraper(ui));
        textField.setUI(ui);
//        ui.getMargin().set(ComponentTextMarginManager.Side.LEFT, 10);
        ui.setRespectionBorder(true);
        textField.setListener(new CustomDocumentListener(new Color(0xD08888)));
        textField.getMargin().set(35, 0, 35, 0);
//        textField.setMaximumFontSize(true);
        textField.setMaximumFontRelevantToHeight(true);
//        textField.setMaximumFontRelevangValue(0.5);
        return textField;
    }
}
