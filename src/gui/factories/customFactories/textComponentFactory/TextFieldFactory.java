package gui.factories.customFactories.textComponentFactory;

import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customComponents.customTextComponents.CustomTextField;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.customUI.wrapers.DarkerHoverComponentWraper;
import gui.margin.ComponentTextMarginMenager;

import java.awt.*;

public class TextFieldFactory implements TextFactory{
    @Override
    public CustomTextComponent createTextField() {
        var textField = new CustomTextField();
        textField.setBackground(Color.ORANGE);
        var ui = new RoundedBorderUI();
        ui.setAdditionaldColor(Color.BLUE, ICustomUI.Index.FIRST);
        textField.setUI(new DarkerHoverComponentWraper(ui));
        textField.setUI(ui);
        textField.getMargin().set(ComponentTextMarginMenager.Side.LEFT, 10);
        textField.getMargin().set(ComponentTextMarginMenager.Side.RIGHT, 10);
        textField.getTextComponent().setForeground(Color.RED);
        return textField;
    }
}
