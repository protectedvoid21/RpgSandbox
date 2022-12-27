package gui.factories.customFactories.textComponentFactory;

import gui.customComponents.customTextComponents.CustomTextComponent;

/**
 * Text factory interface which create some specific kind of CustomTextComponent instance. Method 'createTextField'
 * creates customized panel with label and text field. Method 'createTextArea' creates customized panel with label
 * and text area.
 */
public interface TextFactory {
    CustomTextComponent createTextField();
    CustomTextComponent createTextArea();
}
