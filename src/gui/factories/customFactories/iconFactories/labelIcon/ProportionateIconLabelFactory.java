package gui.factories.customFactories.iconFactories.labelIcon;

import gui.customComponents.iconComponents.IconLabel;

import javax.swing.*;

/**
 * Label factory which creates icon button. Component is auto filled to given space, but contain proportionate so
 * only one side will be at the edge of the layout.
 */
public class ProportionateIconLabelFactory implements ILabelIconFactory {
    @Override
    public JLabel create(String path) {
        return new IconLabel(path, false);
    }
}
