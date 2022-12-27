package gui.factories.customFactories.iconFactories.buttonIcon;

import gui.customComponents.iconComponents.IconButton;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DefaultIconButtonFactory implements ButtonIconFactory{
    @Override
    public JButton create(String path, ActionListener listener) {
        var button = new IconButton(path);
        button.addActionListener(listener);
        return button;
    }
}