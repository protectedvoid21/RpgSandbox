package gui.customComponents.customTextComponents;

import javax.swing.*;

/**
 * Implementation of CustomTextComponent. Offers user panel with custom label and text field which imitate
 * text edit area with some nice style, but currently...it doesnt work.
 */
public class CustomTextArea extends CustomTextComponent {///to fix

    public CustomTextArea() {
        super();
        var textComponent = new JTextArea();
        textComponent.setWrapStyleWord(true);
        textComponent.setLineWrap(true);
        textField = textComponent;
        textField.setEditable(false);
        addComponentsToPanel();
        initializeTextField();

    }
}
