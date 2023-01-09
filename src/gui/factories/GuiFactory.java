package gui.factories;

import gui.customComponents.*;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.factories.customFactories.buttonFactories.ButtonFactory;
import gui.factories.customFactories.buttonFactories.CardDownPanelButtonFactory;
import gui.factories.customFactories.labelFactories.GameGreenLabelFactory;
import gui.factories.customFactories.labelFactories.LabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Base GUI factory used for creating every object used in application. User has to used set method to define
 * specific component factory.
 */
public class GuiFactory {
    private Font currentFont = new Font("Helvetica", Font.PLAIN, 14);

    public enum LabelType {NORMAL, ICON, STRETCH_ICON}
    public enum ButtonType {NORMAL, ICON, STRETCH_ICON, DISABLED_STRETCH_ICON, DISABLED_ICON, DOUBLE, DOUBLE_WITH_ICONS}

    private LabelType labelType = LabelType.NORMAL;
    private ButtonType buttonType = ButtonType.NORMAL;
    private ButtonFactory buttonFactory = new CardDownPanelButtonFactory();
    private LabelFactory labelFactory = new GameGreenLabelFactory();//dorzucic defaultowe typys
    private TextFactory textFactory = new TextFieldFactory();
    private IBorderStrategy borderStrategy;

    public void setBorderStrategy(IBorderStrategy strategy) {
        borderStrategy = strategy;
        labelFactory.setStrategy(strategy);
        buttonFactory.setStrategy(strategy);
        textFactory.setStrategy(strategy);
    }

    public GuiFactory() {
        setBorderStrategy(new DefaultBorderStrategy());
    }


    public AbstractCustomLabel createLabel(String text) {
        AbstractCustomLabel label = null;
        switch (labelType) {
            case ICON -> label = labelFactory.createIconPropLabel(text);
            case NORMAL -> label = labelFactory.createNormalLabel(text);
            case STRETCH_ICON -> label = labelFactory.createIconStretchLabel(text);
        }
        return label;
    }

    public AbstractCustomButton createButton(String text, ActionListener listener){
        return createButton(text, null, listener);
    }

    public AbstractCustomButton createButton(String text, String disabledPath, ActionListener listener) {
        AbstractCustomButton button = null;
        switch (buttonType) {
            case ICON -> button = buttonFactory.createIconPropButton(text, listener);
            case NORMAL -> button = buttonFactory.createNormalButton(text, listener);
            case STRETCH_ICON -> button = buttonFactory.createIconStretchButton(text, listener);
            case DISABLED_ICON -> button = buttonFactory.createDisabledIconPropButton(text, disabledPath,listener);
            case DISABLED_STRETCH_ICON -> button = buttonFactory.createDisabledIconStretchButton(text, disabledPath,listener);
            case DOUBLE -> button = buttonFactory.createBooleanButton(text, disabledPath, true);
            case DOUBLE_WITH_ICONS -> button = buttonFactory.createBooleanButtonWithIcons(text, disabledPath, true, true);
        }
        return button;
    }

    public CustomBooleanButton createButton(String firstText, String secondText, boolean initialValue){
        return buttonFactory.createBooleanButton(firstText, secondText, initialValue);
    }
    public CustomIconBooleanButton createButton(String firstText, String secondText, boolean initialValue, boolean proportionate){
        return buttonFactory.createBooleanButtonWithIcons(firstText, secondText, initialValue, proportionate);
    }

    public void setButtonFactory(ButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
        this.buttonFactory.setFont(currentFont);
        this.buttonFactory.setStrategy(borderStrategy);
    }

    public void setLabelFactory(LabelFactory labelFactory) {
        this.labelFactory = labelFactory;
        this.labelFactory.setFont(currentFont);
        this.labelFactory.setStrategy(borderStrategy);
    }

    public void setCurrentFont(Font newFont) {
        currentFont = newFont;
        labelFactory.setFont(currentFont);
        buttonFactory.setFont(currentFont);
        textFactory.setFont(currentFont);
    }

    public void setFontSize(int fontSize) {
        setCurrentFont(new Font(currentFont.getFontName(), currentFont.getStyle(), fontSize));
    }

    public void setTextFactory(TextFactory textFactory) {
        this.textFactory = textFactory;
    }

    public CustomTextComponent createTextField() {
        return textFactory.createTextField();
    }

    public CustomTextComponent createTextArea() {
        return textFactory.createTextArea();
    }


    public void setLabelType(LabelType type) {
        this.labelType = type;
    }
    public void setButtonType(ButtonType type) {
        this.buttonType = type;
    }


}
