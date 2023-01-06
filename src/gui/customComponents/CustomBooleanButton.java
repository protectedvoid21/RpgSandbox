package gui.customComponents;

import gui.customComponents.iconComponents.StretchIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomBooleanButton extends CustomButton implements IBooleanComponent {
    private String firstString = "";
    private String secondString = "";
//    private StretchIcon icon1;
//    private StretchIcon icon2;
    private boolean value;


    public CustomBooleanButton(boolean initialValue) {
        super();
        setValue(initialValue);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValue(!value);
            }
        });
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
}
