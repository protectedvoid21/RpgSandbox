package gui.customComponents.baseCustomComponents;

import gui.customComponents.abstractComponents.AbstractCustomLabel;

public class CustomLabel extends AbstractCustomLabel {

    public CustomLabel() {
        super("");
    }

    public CustomLabel(String s) {
        super(s);
    }

    @Override
    public void setContent(String  text) {
        setText(text);
    }

    @Override
    public String getContent() {
        return getText();
    }
}
