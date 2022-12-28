package gui.factories;

import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.customFactories.buttonFactories.IButtonFactory;
import gui.factories.customFactories.iconFactories.buttonIcon.IButtonIconFactory;
import gui.factories.customFactories.iconFactories.buttonIcon.DefaultIconButtonFactory;
import gui.factories.customFactories.iconFactories.labelIcon.DefaultIconLabelFactory;
import gui.factories.customFactories.iconFactories.labelIcon.ILabelIconFactory;
import gui.factories.customFactories.labelFactories.ILabelFactory;
import gui.factories.customFactories.textComponentFactory.ITextFactory;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Base GUI factory used for creating every object used in application. User has to used set method to define
 * specific component factory.
 */
public class GuiFactory {
    private IButtonFactory buttonFactory;
    private ILabelFactory labelFactory;//dorzucic defaultowe typy
    private ITextFactory textFactory;
    private IButtonIconFactory buttonIconFactory = new DefaultIconButtonFactory();
    private ILabelIconFactory labelIconFactory = new DefaultIconLabelFactory();

    public GuiFactory() {
    }

    public JLabel createLabel(String text) {
        return labelFactory.create(text);
    }

    public JButton createButton(String text, ActionListener listener) {
        return buttonFactory.create(text, listener);
    }

    public void setButtonFactory(IButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
    }

    public void setLabelFactory(ILabelFactory labelFactory) {
        this.labelFactory = labelFactory;
    }

    public void setTextFactory(ITextFactory textFactory) {
        this.textFactory = textFactory;
    }

    public void setButtonIconFactory(IButtonIconFactory buttonIconFactory) {
        this.buttonIconFactory = buttonIconFactory;
    }

    public void setLabelIconFactory(ILabelIconFactory labelIconFactory) {
        this.labelIconFactory = labelIconFactory;
    }

    public CustomTextComponent createTextField() {
        return textFactory.createTextField();
    }

    public CustomTextComponent createTextArea() {
        return textFactory.createTextArea();
    }

    public JLabel createIconLabel(String path) {
        return labelIconFactory.create(path);
    }

    public JButton createIconButton(String path, ActionListener listener) {
        return buttonIconFactory.create(path, listener);
    }//dorzucic factory do icon components
}
