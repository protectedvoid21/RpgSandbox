package gui.factories.customFactories.iconFactories.buttonIcon;

import gui.customComponents.iconComponents.IconButton;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Button factory which creates icon button. Component is auto filled to given space, but contain proportionate so
 * only one side will be at the edge of the layout.
 */
public class ProportionateIconButtonFactory implements ButtonIconFactory {
    @Override
    public JButton create(String path, ActionListener listener) {
        var button = new IconButton(path, true);
        button.addActionListener(listener);
        return button;
    }
}
