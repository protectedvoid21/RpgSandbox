package gui.views.gamePanel.optionsPanels;

import gui.factories.GuiFactory;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class OneDataOptionsPanel extends OptionsPanel {
    public OneDataOptionsPanel(GuiFactory factory, int size) {
        super(factory, size);
    }

    public void setDisabledIndexes(ArrayList<Integer> indexes) {
        for (var button: buttons) {
            button.setEnabled(true);
        }
        for (var index : indexes) {
            if (index < size) {
                buttons.get(index).setEnabled(false);
            }
        }

    }

    public void setDisabledIndexes(Integer... indexes) {
        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));

    }

}
