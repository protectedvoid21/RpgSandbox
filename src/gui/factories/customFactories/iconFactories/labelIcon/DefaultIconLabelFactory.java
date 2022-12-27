package gui.factories.customFactories.iconFactories.labelIcon;

import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.IconLabel;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DefaultIconLabelFactory implements LabelIconFactory {
    @Override
    public JLabel create(String path   ) {
        return new IconLabel(path);
    }
}