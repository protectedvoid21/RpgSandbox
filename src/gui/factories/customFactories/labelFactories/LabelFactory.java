package gui.factories.customFactories.labelFactories;

import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.factories.customFactories.ComponentFactory;

/**
 * Label factory interface which create some specific kind of QLabel
 */
public abstract class LabelFactory extends ComponentFactory {
    public abstract AbstractCustomLabel createNormalLabel(String text);
    public abstract AbstractCustomLabel createIconPropLabel(String path);
    public abstract AbstractCustomLabel createIconStretchLabel(String path);
}
