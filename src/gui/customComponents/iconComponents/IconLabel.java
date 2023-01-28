package gui.customComponents.iconComponents;

import gui.customComponents.abstractComponents.AbstractCustomLabel;

public class IconLabel extends AbstractCustomLabel implements IIconComponent {
    private StretchIcon icon;

    public IconLabel(String iconPath) {
        this(iconPath, false);
    }

    @Override
    public void setContent(String text) {
        setContent(text, icon.isProportionate());
    }

    private void setContent(String text, boolean prop){
        icon = new StretchIcon( text, prop);
        setIcon(icon);
    }

    public IconLabel(String iconPath, boolean prop) {
        super();
        setOpaque(false);
        setContent(iconPath, prop);
    }

    public StretchIcon getCustomIcon() {
        return icon;
    }

    @Override
    public String getContent() {
        return icon.getPath();
    }


}
