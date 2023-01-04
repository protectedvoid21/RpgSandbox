package gui.card;

import gui.factories.GuiFactory;

public class EntriesCard extends Card {
    public EntriesCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    protected DetailButtonsCard createDetailButton() {
        return new EntriesDetailButtonsCard(factory);
    }
}
