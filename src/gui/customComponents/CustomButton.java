package gui.customComponents;

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
    }
}
