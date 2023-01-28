package gui.customComponents.iconComponents;

import gui.customComponents.abstractComponents.AbstractCustomButton;

public class IconButton extends AbstractCustomButton implements IIconComponent {

    protected StretchIcon icon;
    private boolean hasSameDisabledIcon = false;

    public IconButton(String iconPath) {
        this(iconPath, false);
    }

    @Override
    public void setContent(String text) {
        setContent(text, icon.isProportionate());
    }

    private void setContent(String text, boolean prop) {
        icon = new StretchIcon(text, prop);
        if (hasSameDisabledIcon) {
            setDisabledIcon(icon);
        }
        setIcon(icon);
    }

    public void setHasSameDisabledIcon(boolean value) {
        this.hasSameDisabledIcon = value;
    }


    public IconButton(String iconPath, boolean prop) {
        super();
        setContent(iconPath, prop);
    }

    public StretchIcon getCustomIcon() {
        return icon;
    }

    @Override
    public String getContent() {
        return icon.getPath();
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
    }
}
