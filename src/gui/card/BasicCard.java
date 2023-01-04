package gui.card;

import gui.factories.GuiFactory;

public class BasicCard extends Card{
    public BasicCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButton() {
        return new NormalDetailButtonsCard(factory);
    }
}
