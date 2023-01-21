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
        //        var scroll = new JScrollPane(textComponent);
//        scroll.setOpaque(false);
//        scroll.setViewportView(textComponent);
//        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        add(scroll);
//        textComponent.setAutoscrolls(true);
        textComponent.setWrapStyleWord(true);
        textComponent.setLineWrap(true);
        textField = textComponent;
//        add(textField);
        addComponentsToPanel();
        initializeTextField();

    }
}
