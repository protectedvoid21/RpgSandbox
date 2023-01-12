package gui.views.gamePanel.gamePanels;

import gui.card.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.views.gamePanel.Point;
import gui.views.gamePanel.gamePanels.BaseGamePanel;
import gui.views.gamePanel.optionsPanels.CreatorOptionsPanel;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;

public class CreatorPanel extends BaseGamePanel {
//    private String basePath = "src/gui/plus.png";
private String basePath = Card.EMPTY_DATA_CONTENT;

    public CreatorPanel(IOverallFactory factory, int size) {
        super(factory, size);
    }

    @Override
    public void initialize() {
        super.initialize();
        var array = new ArrayList<AbstractMap.SimpleEntry<gui.views.gamePanel.Point, String>>();

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                array.add(new AbstractMap.SimpleEntry<>(new gui.views.gamePanel.Point(i, j), basePath));
            }
        }
        applyContent(array);
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
        var array = new ArrayList<AbstractMap.SimpleEntry<gui.views.gamePanel.Point, String>>();
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                if (!manager.getMiddleComponent(i, j).getComponent().getContent().equals(basePath)) {
                    array.add(new AbstractMap.SimpleEntry<>(new gui.views.gamePanel.Point(i, j), basePath));
                }
            }
        }
        applyContent(array);
    }

    public void applyNewCreatureOnPosition(String path, gui.views.gamePanel.Point position) {
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
        var array = new ArrayList<AbstractMap.SimpleEntry<gui.views.gamePanel.Point, String>>();
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                if (manager.getMiddleComponent(i, j).getComponent().getContent().equals(basePath)) {
                    manager.getMiddleComponent(i, j).getComponent().setEnabled(false);
                    array.add(new AbstractMap.SimpleEntry<>(new Point(i, j), Card.EMPTY_DATA_CONTENT));
                }
            }
        }
        applyContent(array);
    }

}