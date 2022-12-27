package gui.factories.customFactories.iconFactories.buttonIcon;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ButtonIconFactory {
    JButton create(String path, ActionListener listener);
}
