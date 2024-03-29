package gui.factories.customFactories.buttonFactories;

import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.customComponents.booleanComponents.CustomBooleanButton;
import gui.customComponents.booleanComponents.CustomIconBooleanButton;
import gui.customComponents.booleanComponents.MultiplyButton;
import gui.factories.customFactories.ComponentFactory;

import java.awt.event.ActionListener;

/**Button abstract factory which create some specific kind of QButton*/
public abstract class ButtonFactory extends ComponentFactory {

    public abstract AbstractCustomButton createNormalButton(String text, ActionListener listener);
    public abstract MultiplyButton createMultiplyButton();
    public abstract AbstractCustomButton createIconPropButton(String text, ActionListener listener);
    public abstract AbstractCustomButton createIconStretchButton(String text, ActionListener listener);
    public abstract AbstractCustomButton createDisabledIconPropButton(String text1, String text2, ActionListener listener);
    public abstract AbstractCustomButton createDisabledIconStretchButton(String text, String text2, ActionListener listener);
    public abstract CustomBooleanButton createBooleanButton(String text1, String text2, boolean initialValue);
    public abstract CustomIconBooleanButton createBooleanButtonWithIcons(String path1, String path2, boolean initialValue, boolean proportionate);

}
