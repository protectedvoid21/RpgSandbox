package gui.factories.customFactories.textComponentFactory;

import gui.customComponents.customTextComponents.CustomTextComponent;

public interface TextFactory {
    CustomTextComponent createTextField();
    CustomTextComponent createTextArea();
}
