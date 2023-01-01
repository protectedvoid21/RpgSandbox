package gui.factories.customFactories.buttonFactories;

import gui.customComponents.CustomButton;
import gui.customUI.customUIStyles.borderStrategies.IBorderStrategy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.ComponentFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**Button abstract factory which create some specific kind of QButton*/
public abstract class ButtonFactory extends ComponentFactory {

    public abstract CustomButton createNormalButton(String text, ActionListener listener);
    public abstract CustomButton createIconPropButton(String text, ActionListener listener);
    public abstract CustomButton createIconStretchButton(String text, ActionListener listener);
    public abstract CustomButton createDisabledIconPropButton(String text1,String text2, ActionListener listener);
    public abstract CustomButton createDisabledIconStretchButton(String text,String text2, ActionListener listener);

}
