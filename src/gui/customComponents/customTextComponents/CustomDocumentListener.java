package gui.customComponents.customTextComponents;

import gui.customComponents.CustomLabel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Some kind of decorator for customTextComponent. Offers possibility of changing color when something is being
 * entered to text component.
 */
public class CustomDocumentListener implements DocumentListener {
    private CustomLabel label;
    private JTextComponent textComponent;
    private Color previousColor;
    private Timer t = null;
    private Color updatedColor;

    public CustomDocumentListener(Color color) {
        updatedColor = color;
    }

    public void setLabel(CustomLabel label) {
        this.label = label;

    }


    public void setTextComponent(JTextComponent textComponent) {
        this.textComponent = textComponent;
    }

    //to fix when some other background filters are used
    @Override
    public void insertUpdate(DocumentEvent e) {
        changedAction(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changedAction(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    private void changedAction(DocumentEvent e) {
        if (t == null) {
            t = new Timer(1000, new ActionListener() {
                int textSize = textComponent.getText().length();

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textSize == textComponent.getText().length()) {
                        label.setBackground(previousColor);
                        ((Timer) e.getSource()).stop();
                        t = null;
                    }
                    textSize = textComponent.getText().length();
                }
            });
            t.start();
            previousColor = label.getBackground();
        }
        label.setBackground(updatedColor);
    }
}
