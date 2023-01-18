package gui.views.gamePanel.optionsPanels;

import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import java.util.ArrayList;

public class GameOptionsPanel extends OneDataOptionsPanel {
    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    public GameOptionsPanel(GuiFactory factory, int size) {
        super(factory);
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
//            if (i < size) {
                var label = factory.createLabel(data);
                labels.add(label);
                customPanelAttackChoser.addMiddleComponent(label, i, 10);
//            }
            i++;
        }
        setCorrectVisibility();
        SharedCmpsFont.setUniformFont(labels);
    }

    @Override
    public void initializeButtonsData(ArrayList<String> dataMap) {
        super.initializeButtonsData(dataMap);
        int space = (int)((10-size)/(double)2);
        customPanelAttackChoser.getCmp().addSpace(space, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
    }
}
