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
        var textField = new CustomTextArea();
        textField.setFont(font);
        textField.getTextComponent().setForeground(new Color(0000000));
        textField.setBackground(new Color(0x9BEC82));
        var ui = new RoundedBorderUI(strategy, 2, 10);
        ui.setAdditionaldColor(new Color(0x1A3D10), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0x206E0A), ICustomUI.Index.SECOND);
        textField.setUI(new ChangingBorderColorWraper(ui){
            @Override
            protected boolean isOn() {
                return textField.getTextComponent().isEditable();
            }
        });
        textField.setUI(ui);
        ui.setRespectionBorder(true);
        textField.setListener(new CustomDocumentListener(new Color(0x697A69)));
        textField.getMargin().set(5, 5, 5, 5);
        textField.setFont(22);
        return textField;
    }

    private CustomTextComponent initializeTextComponent(CustomTextComponent textField) {
        textField.setFont(font);
        textField.getTextComponent().setForeground(new Color(0000000));
        textField.setBackground(new Color(0x9BEC82));
        var ui = new RoundedBorderUI(strategy, 5, 10);
        ui.setAdditionaldColor(new Color(0x1A3D10), ICustomUI.Index.FIRST);
        ui.setAdditionaldColor(new Color(0x206E0A), ICustomUI.Index.SECOND);
        textField.setUI(new ChangingBorderColorWraper(ui));
        textField.setUI(ui);
        ui.setRespectionBorder(true);
        textField.setListener(new CustomDocumentListener(new Color(0x697A69)));
        textField.getMargin().set(30, 7, 30, 7);
        textField.setMaximumFontSize(true);
        textField.setMaximumFontRelevantToHeight(true);
        return textField;
    }
}
