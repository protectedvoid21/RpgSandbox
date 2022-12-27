package gui.factories;

import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.IconLabel;
import gui.factories.customFactories.buttonFactories.ButtonFactory;
import gui.factories.customFactories.labelFactories.LabelFactory;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;

public class GuiFactory {
    private ButtonFactory buttonFactory;
    private LabelFactory labelFactory;
    public JLabel createLabel(String text){
        return labelFactory.create(text);
    }
    public  JButton createButton(String text, ActionListener listener){
        return buttonFactory.create(text, listener);
    }

    public void setButtonFactory(ButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
    }

    public void setLabelFactory(LabelFactory labelFactory) {
        this.labelFactory = labelFactory;
    }

    public  JTextComponent createTextField(){
        return null;
    }
    public JLabel createIconLabel(String path){
        return new IconLabel(path);
    }
    public JButton createIconButton(String path, ActionListener listener){
       var button = new IconButton(path);
       button.addActionListener(listener);
       return button;
    }
}
