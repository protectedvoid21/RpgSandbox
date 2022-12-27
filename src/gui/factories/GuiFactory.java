package gui.factories;

import gui.customComponents.customTextComponents.CustomDocumentListener;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.IconLabel;
import gui.factories.customFactories.buttonFactories.ButtonFactory;
import gui.factories.customFactories.iconFactories.buttonIcon.ButtonIconFactory;
import gui.factories.customFactories.iconFactories.buttonIcon.DefaultIconButtonFactory;
import gui.factories.customFactories.iconFactories.labelIcon.DefaultIconLabelFactory;
import gui.factories.customFactories.iconFactories.labelIcon.LabelIconFactory;
import gui.factories.customFactories.labelFactories.LabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFactory;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiFactory {
    private ButtonFactory buttonFactory;
    private LabelFactory labelFactory;
    private TextFactory textFactory;
    private ButtonIconFactory buttonIconFactory = new DefaultIconButtonFactory();
    private LabelIconFactory labelIconFactory = new DefaultIconLabelFactory();

    public GuiFactory(){
    }

    public JLabel createLabel(String text) {
        return labelFactory.create(text);
    }

    public JButton createButton(String text, ActionListener listener) {
        return buttonFactory.create(text, listener);
    }

    public void setButtonFactory(ButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
    }

    public void setLabelFactory(LabelFactory labelFactory) {
        this.labelFactory = labelFactory;
    }

    public void setTextFactory(TextFactory textFactory) {
        this.textFactory = textFactory;
    }

    public void setButtonIconFactory(ButtonIconFactory buttonIconFactory) {
        this.buttonIconFactory = buttonIconFactory;
    }

    public void setLabelIconFactory(LabelIconFactory labelIconFactory) {
        this.labelIconFactory = labelIconFactory;
    }

    public CustomTextComponent createTextField() {
        return textFactory.createTextField();
    }

    public CustomTextComponent createTextArea(){
        return textFactory.createTextArea();
    }

    public JLabel createIconLabel(String path) {
        return labelIconFactory.create(path);
    }

    public JButton createIconButton(String path, ActionListener listener) {
        return buttonIconFactory.create(path, listener);
    }//dorzucic factory do icon components
}
