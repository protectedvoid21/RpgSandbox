package gui.customComponents.customTextComponents;

import javax.swing.*;

public class CustomTextArea extends CustomTextComponent {///to fix
    public CustomTextArea() {
        super();
        var textComponent = new JTextArea();
        var scroll = new JScrollPane(textComponent);
//        scroll.setOpaque(false);
//        scroll.setViewportView(textComponent);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
//        textComponent.setAutoscrolls(true);
        textComponent.setWrapStyleWord(true);
//        textComponent.setLineWrap(true);
        textField = textComponent;
//        add(textField);
        addComponentsToPanel();
        initializeTextField();

    }
}
