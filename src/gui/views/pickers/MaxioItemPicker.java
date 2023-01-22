package gui.views.pickers;

import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;

public class MaxioItemPicker extends ItemPicker{
    private AbstractCustomButton button;

    public MaxioItemPicker(GuiFactory factory) {
        super(factory);
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        button = factory.createButton("USE", null);
        button.getCustomUI().setOffSet(15);
        menager.addMainComponent(5);
        menager.addMiddleComponent(button, 2,10);
        menager.getMainComponent(2).addSpace(1);
    }

    public AbstractCustomButton getButton() {
        return button;
    }
}
