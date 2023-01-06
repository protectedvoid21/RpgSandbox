package gui.customComponents.customTextComponents;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Some kind of decorator for customTextComponent. Offers possibility of changing color when something is being
 * entered to text component.
 */
public class CustomDocumentListener implements DocumentListener {
    private AbstractCustomLabel label;
    private boolean pressed = false;
    private JTextComponent textComponent;
    private Color previousColor;
    private Timer t = null;
    private Color updatedColor;

    public CustomDocumentListener(Color color) {
        updatedColor = color;
    }

    public void setLabel(AbstractCustomLabel label) {
        this.label = label;
    }


    public void setTextComponent(JTextComponent textComponent) {
        this.textComponent = textComponent;
        textComponent.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                pressed = true;
//                var f = label.getCustomUI().getRelevantFont(label.getText());
//                textComponent.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(),
//                        f.getSize()));
//                label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(),
//                        f.getSize()));
//                System.out.println(label.getFont());
//                System.out.println(textComponent.getFont());
//                System.out.println("kurwaaaaaaaaaaaaaaaaaaaaaaaa");
//                System.out.println(textComponent.getForeground());
//                System.out.println(textComponent.getFont());
//                System.out.println(label.getFont());
//                System.out.println(textComponent.getBackground());
//                System.out.println(label.getBackground()+"keeeeeeeeeeeeeeeeekeeeeeeeeeeeeeeeeeeeeeeeeeeeeveeeeeeeeeee");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pressed = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressed = false;
            }
        });
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
        System.out.println(pressed);
        if (pressed) {
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
}
