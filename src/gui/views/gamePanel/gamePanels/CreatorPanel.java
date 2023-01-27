package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.views.gamePanel.optionsPanels.CreatorOptionsPanel;
import gui.views.gamePanel.optionsPanels.OneDataOptionsPanel;

import java.util.AbstractMap;
import java.util.ArrayList;

public class CreatorPanel extends BaseGamePanel {
private String basePath = Card.EMPTY_DATA_CONTENT;
private OneDataOptionsPanel panel;

    public CreatorPanel(IOverallFactory factory, int size) {
        super(factory, size);
    }
    @Override
    public void initialize() {
        super.initialize();
        var array = new ArrayList<AbstractMap.SimpleEntry<Vector2, String>>();

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                array.add(new AbstractMap.SimpleEntry<>(new Vector2(i, j), basePath));
            }
        }
        applyContent(array);
    }
    public void setOptionsDisabledIndexes(ArrayList<Integer> indexes) {
        panel.setDisabledIndexes(indexes);
    }

    public void setOptionsDisabledIndexes(Integer... indexes) {
        panel.setDisabledIndexes(indexes);
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
        var array = new ArrayList<AbstractMap.SimpleEntry<Vector2, String>>();
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                if (!manager.getMiddleComponent(i, j).getComponent().getContent().equals(basePath)) {
                    array.add(new AbstractMap.SimpleEntry<>(new Vector2(i, j), basePath));
                }
            }
        }
        applyContent(array);
    }

    public void applyNewCreatureOnPosition(String path, Vector2 position) {
        applyWithoutRemovingContent(new AbstractMap.SimpleEntry<>(position, path));
        addDisabledIndex(position);
    }

    @Override
    public void createOptionsPanel() {

        panel = new CreatorOptionsPanel(factory.getFactory(), 3);
        optionsPanel = panel;
        optionsPanel.initialize(weight);
    }

    public void setWholePanelDisabled() {
        var array = new ArrayList<AbstractMap.SimpleEntry<Vector2, String>>();
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                manager.getMiddleComponent(i, j).getComponent().setEnabled(false);
                if (manager.getMiddleComponent(i, j).getComponent().getContent().equals(basePath)) {
                    array.add(new AbstractMap.SimpleEntry<>(new Vector2(i, j), Card.EMPTY_DATA_CONTENT));
                }
            }
        }
        applyWithoutRemovingContent(array);
    }


}
