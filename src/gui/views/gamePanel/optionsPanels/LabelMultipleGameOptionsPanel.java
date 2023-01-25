package gui.views.gamePanel.optionsPanels;

import game.generals.Vector2;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class LabelMultipleGameOptionsPanel extends MultipleGameOptionsPanel {
    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    public LabelMultipleGameOptionsPanel(GuiFactory factory, int size) {
        super(factory, size);
    }
    @Override
    public double getPercentFilledSizeY() {
        return 1;
    }
    public void initializeLabelsData(ArrayList<String> dataMap) {
        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        int i = 0;
        setPotentialSize(dataMap.size());
        for (var data : dataMap) {
            if (i < size) {
                var label = factory.createLabel(data);
                labels.add(label);
                customPanelAttackChoser.addMiddleComponent(label, i, 10);
            }
            i++;
        }
        setCorrectVisibility();
        SharedCmpsFont.setUniformFont(labels);
    }
}
