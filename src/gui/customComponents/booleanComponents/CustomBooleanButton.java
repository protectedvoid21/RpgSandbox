package gui.customComponents.booleanComponents;

import gui.customComponents.CustomButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomBooleanButton extends CustomButton implements IBooleanComponent {
    private String firstString = "";
    private String secondString = "";
    private boolean value;
    private ActionListener on = e -> {
    };
    private ActionListener off = e -> {
    };


    public CustomBooleanButton(boolean initialValue) {
        super();
        setValue(initialValue);
        addActionListener(e -> {
            setValue(!value);
            if (value){
                on.actionPerformed(e);
            }else{
                off.actionPerformed(e);
            }
        });
    }

    public void setListeners(ActionListener on, ActionListener off){
        this.on = on;
        this.off = off;
    }

    public void setDoubleTextContent(String first, String second) {
        firstString = first;
        secondString = second;
        setValue(value);
    }

    private void setValue(boolean value) {
        this.value = value;
        setText(value ? firstString : secondString);
    }

    public boolean getStatus() {
        return value;
    }


    @Override
    public void setContent(String text) {
        setValue(!text.isEmpty());
    }

    @Override
    public String getContent() {
        return value ? "1" : "";
    }

}
