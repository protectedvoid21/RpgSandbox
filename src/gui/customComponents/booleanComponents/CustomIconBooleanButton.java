package gui.customComponents.booleanComponents;

import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.StretchIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomIconBooleanButton extends IconButton implements IBooleanComponent {
    private StretchIcon secondIcon;
    private boolean value;



    public CustomIconBooleanButton(String iconPath1, String iconPath2, boolean initialValue) {
        super(iconPath1);
        initialize(iconPath2, initialValue, false);

    }

    public CustomIconBooleanButton(String iconPath1, String iconPath2, boolean initialValue, boolean prop) {
        super(iconPath1, prop);
        initialize(iconPath2, initialValue, prop);
    }

    private void initialize(String content, boolean initialValue, boolean prop){
        secondIcon = new StretchIcon(content, prop);
        addActionListener(e -> setValue(!value));
    }

    public void setDoubleTextContent(String first, String second) {
        icon = new StretchIcon(first, icon.isProportionate());
        secondIcon = new StretchIcon(second, secondIcon.isProportionate());
        setValue(value);
    }

    private void setValue(boolean value) {
        this.value = value;
        setIcon(value ? icon : secondIcon);
    }

    public boolean getStatus() {
        return value;
    }
    public StretchIcon getSecondIcon(){
        return secondIcon;
    }


    @Override
    public void setContent(String text) {
        setValue(!text.isEmpty());
    }
}
