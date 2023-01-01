package gui.factories.customFactories.labelFactories;

import gui.customComponents.CustomLabel;
import gui.customUI.customUIStyles.CustomUI;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.ComponentFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Label factory interface which create some specific kind of QLabel
 */
public abstract class LabelFactory extends ComponentFactory {
    public abstract CustomLabel createNormalLabel(String text);
    public abstract CustomLabel createIconPropLabel(String path);
    public abstract CustomLabel createIconStretchLabel(String path);
}
