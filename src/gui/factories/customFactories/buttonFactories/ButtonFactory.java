package gui.factories.customFactories.buttonFactories;

import javax.swing.*;
import java.awt.event.ActionListener;

/**Button factory interface which create some specific kind of QButton*/
public interface ButtonFactory {
    JButton create(String text, ActionListener listener);
}
