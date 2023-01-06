package gui.customComponents.iconComponents;

import gui.customComponents.AbstractCustomButton;

public class IconButton extends AbstractCustomButton implements IIconComponent {

    protected StretchIcon icon;
    public IconButton(String iconPath) {
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

    public IconButton(String iconPath, boolean prop) {
        super();
//        setOpaque(false);
//        setBorder(new LineBorder(Color.RED, 5, true));//to fix
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
