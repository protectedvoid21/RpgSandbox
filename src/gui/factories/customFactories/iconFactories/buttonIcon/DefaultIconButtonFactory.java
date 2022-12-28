package gui.factories.customFactories.iconFactories.buttonIcon;

import gui.customComponents.iconComponents.IconButton;

import javax.swing.*;
import java.awt.event.ActionListener;


/**Default button factory which creates base icon button. Component is auto filled to given space in layout, doesn't contain proportionate*/
public class DefaultIconButtonFactory implements IButtonIconFactory {
    @Override
    public JButton create(String path, ActionListener listener) {
        var button = new IconButton(path);
        button.addActionListener(listener);
        return button;
    }
}