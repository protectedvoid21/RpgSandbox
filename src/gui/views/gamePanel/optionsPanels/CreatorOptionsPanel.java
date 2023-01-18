package gui.views.gamePanel.optionsPanels;

import gui.factories.GuiFactory;

import java.util.ArrayList;

public class CreatorOptionsPanel extends OneDataOptionsPanel {
    public CreatorOptionsPanel(GuiFactory factory, int size) {
        super(factory);
    }

    @Override
    public double getPercentFilledSizeY() {
        return 0.5;
    }

    @Override
    public void initializeButtonsData(ArrayList<String> dataMap) {
        super.initializeButtonsData(dataMap);
        setCorrectVisibility();
    }
}
