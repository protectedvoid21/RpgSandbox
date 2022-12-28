package gui.factories.customFactories.iconFactories.labelIcon;

import javax.swing.*;

/**Label factory interface which create some specific kind of QLabel which contains given icon inside*/
public interface ILabelIconFactory {
    JLabel create(String path);
}
