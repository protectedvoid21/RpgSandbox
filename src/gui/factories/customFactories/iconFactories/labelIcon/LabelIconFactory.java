package gui.factories.customFactories.iconFactories.labelIcon;

import javax.swing.*;
import java.awt.event.ActionListener;

/**Label factory interface which create some specific kind of QLabel which contains given icon inside*/
public interface LabelIconFactory {
    JLabel create(String path);
}
