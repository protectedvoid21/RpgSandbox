package gui.factories;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public abstract class GuiFactory {
    public abstract JLabel createLabel(String text);
    public abstract JButton createButton(String text, ActionListener listener);
    public abstract JTextComponent createTextField();
    public JLabel createIconLabel(String path){
        return null;
    }
    public JLabel createIconButton(String path, Function command){
        return null;
    }
}
