package gui.factories.customFactories.buttonFactories;

import javax.swing.*;
import java.awt.event.ActionListener;

/**Button factory interface which create some specific kind of QButton*/
public interface IButtonFactory {
    JButton create(String text, ActionListener listener);
}
