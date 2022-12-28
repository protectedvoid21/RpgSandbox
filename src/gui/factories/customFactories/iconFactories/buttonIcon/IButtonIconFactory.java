package gui.factories.customFactories.iconFactories.buttonIcon;

import javax.swing.*;
import java.awt.event.ActionListener;

/**Button factory interface which create some specific kind of QButton which contains given icon inside*/
public interface IButtonIconFactory {
    JButton create(String path, ActionListener listener);
}
