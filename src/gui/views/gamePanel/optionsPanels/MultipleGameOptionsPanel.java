package gui.views.gamePanel.optionsPanels;

import game.generals.Vector2;
import gui.card.SharedCmpsFont;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleGameOptionsPanel extends OptionsPanel {
    private ArrayList<AbstractCustomLabel> labels = new ArrayList<>();
    private OptionsPanelData data = new OptionsPanelData();
    public MultipleGameOptionsPanel(GuiFactory factory, int size) {
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
    public void setDisabledIndexes(Vector2 point, ArrayList<Integer> indexes) {
       data.setPointData(point, indexes);
    }

    public void setDisabledIndexes(Vector2 point, Integer... indexes) {
        setDisabledIndexes(point,new ArrayList<>(Arrays.asList(indexes)));
    }

    @Override
    public void setCurrentIndexes(int x, int y) {
        super.setCurrentIndexes(x, y);
        for (var button: buttons) {
            button.setEnabled(true);
        }
        for (var index : data.getPointData(new Vector2(x, y))) {
            if (index < size) {
                buttons.get(index).setEnabled(false);
            }
        }
    }

//    @Override
//    public void initializeButtonsData(ArrayList<String> dataMap) {
//        for (int j = 0; j<maximumSize; j++){
//            customPanelAttackChoser.getMainComponent(j).setVisible(j<size?true:false);
//        }     super.initializeButtonsData(dataMap);
//
//    }
}
