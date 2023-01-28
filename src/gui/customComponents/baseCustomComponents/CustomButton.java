package gui.customComponents.baseCustomComponents;

import gui.customComponents.abstractComponents.AbstractCustomButton;

public class CustomButton extends AbstractCustomButton {
    public CustomButton() {
        super("");
    }

    public CustomButton(String s) {
        super(s);
    }
    @Override
    public void setContent(String  text) {
        setText(text);
        if (getCustomUI() != null)
            getCustomUI().setRelevantFont(getText());
    }

    @Override
    public String getContent() {
        return getText();
    }

}
