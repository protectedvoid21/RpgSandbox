package gui.views.gamePanel.optionsPanels;

import gui.factories.GuiFactory;

public class CreatorOptionsPanel extends OptionsPanel {
    public CreatorOptionsPanel(GuiFactory factory, int size) {
        super(factory, size);
    }

    @Override
    public double getPercentFilledSizeY() {
        return 0.5;
    }
}
