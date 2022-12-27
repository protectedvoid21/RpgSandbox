package gui.customComponents.customTextComponents;

import gui.customComponents.customTextComponents.CustomTextComponent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Implementation of CustomTextComponent. Offers user panel with custom label and text field which imitate one line
 * text edit field with some nice style.
 */
public class CustomTextField extends CustomTextComponent {

    public CustomTextField() {
        super();
        textField = new JTextField();
        addComponentsToPanel();
        initializeTextField();
    }
}
