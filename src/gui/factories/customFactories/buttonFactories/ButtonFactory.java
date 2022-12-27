package gui.factories.customFactories.buttonFactories;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ButtonFactory {
    JButton create(String text, ActionListener listener);
}
