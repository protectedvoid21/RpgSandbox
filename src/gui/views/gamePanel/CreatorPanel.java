package gui.views.gamePanel;

import gui.card.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.views.gamePanel.optionsPanels.CreatorOptionsPanel;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;

public class CreatorPanel extends BaseGamePanel {
    private String basePath = "src/gui/plus.png";

    public CreatorPanel(IOverallFactory factory, int size) {
        super(factory, size);
    }

    @Override
    public void initialize() {
        super.initialize();
        var array = new ArrayList<AbstractMap.SimpleEntry<Point, String>>();

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                array.add(new AbstractMap.SimpleEntry<>(new Point(i, j), basePath));
            }
        }
        applyContent(array);
    }

    public void applyNewCreatureOnPosition(String path, Point position) {
        applyContent(new AbstractMap.SimpleEntry<>(position, path));
        setDisabledIndexes(position);
    }

    @Override
    public void createOptionsPanel() {
        optionsPanel = new CreatorOptionsPanel(factory.getFactory(), 3);
        optionsPanel.initialize(weight);
        optionsPanel.setBorderColor(Color.RED);
    }

    public void setWholePanelDisabled() {
        var array = new ArrayList<AbstractMap.SimpleEntry<Point, String>>();
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                if (manager.getMiddleComponent(i, j).getComponent().getContent().equals(basePath)){
                    manager.getMiddleComponent(i,j).getComponent().setEnabled(false);
                    array.add(new AbstractMap.SimpleEntry<>(new Point(i, j), Card.EMPTY_DATA_CONTENT));
                }
            }
        }
        applyContent(array);
    }

}
