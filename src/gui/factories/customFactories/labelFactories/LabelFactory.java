package gui.factories.customFactories.labelFactories;

import javax.swing.*;

/**Label factory interface which create some specific kind of QLabel*/
public interface LabelFactory {
    JLabel create(String text);
}
