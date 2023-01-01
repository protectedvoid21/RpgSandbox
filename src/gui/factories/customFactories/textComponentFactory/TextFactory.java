package gui.factories.customFactories.textComponentFactory;

import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.factories.customFactories.ComponentFactory;

import java.awt.*;

/**
 * Text factory interface which create some specific kind of CustomTextComponent instance. Method 'createTextField'
 * creates customized panel with label and text field. Method 'createTextArea' creates customized panel with label
 * and text area.
 */
public abstract class TextFactory extends ComponentFactory {
   public abstract CustomTextComponent createTextField();
    public abstract CustomTextComponent createTextArea();
}
