package gui.views.gamePanel.gamePanels;

import game.generals.Vector2;
import gui.factories.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.BackgroundView;
import gui.views.gamePanel.optionsPanels.OneDataOptionsPanel;
import gui.views.gamePanel.optionsPanels.OptionsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseGamePanel extends BackgroundView {
    private Color baseBackColor;

    private Color secondBackColor = Color.YELLOW;
    private ComponentPanelMenager generalManager;
    protected JPanel panel = new JPanel();
    protected OptionsPanel optionsPanel;//ale inny
    protected IOverallFactory factory;//
    private OverlayLayout layout;//
    protected int maxIndex;
    protected final int weight;//
    public DefaultCustomMenuMenager<AbstractCustomButton> manager =
            new DefaultCustomMenuMenager<AbstractCustomButton>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);//



    public BaseGamePanel(IOverallFactory factory, int size) {
        layout = new OverlayLayout(panel);
        this.weight = 400 / size;
        panel.setLayout(layout);
        this.maxIndex = size;
        this.factory = factory;
        createOptionsPanel();
        optionsPanel.applyUnivibilityAfterClicked();
    }
    public void setBorder(Color color, int value){
        generalManager.setBorderData(color, new AverageBorderStartegy(), value);
        optionsPanel.setBorder(color, value);
    }

    public void initialize() {
        generalManager = new ComponentPanelMenager(panel, 60);
        generalManager.addSpace(1);
        panel.setOpaque(false);
        generalManager.setBackground(new Color(0x2F5B51));
        generalManager.setHasUniqueColor(true);
//        generalManager.setBorderData(Color.RED, new AverageBorderStartegy(), 10);
//        factory.getFactory().setButtonFactory(new BasicButton());
        factory.getFactory().setButtonType(GuiFactory.ButtonType.ICON);
        factory.getFactory().setLabelType(GuiFactory.LabelType.ICON);
        for (int i = 0; i < maxIndex; i++) {
            manager.addMainComponent(5);
            for (int j = 0; j < maxIndex; j++) {
                var but = factory.getFactory().createButton(Card.EMPTY_DATA_CONTENT, null);
                but.setHasDisabledColor(true);
                but.setBackground(new Color(0xffca7a));
                but.setSecondDisabledColor(Color.YELLOW);
                manager.addMiddleComponent(but, i, 5);
                int finalI = i;
                int finalJ = j;
                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optionsPanel.getCurrentPoint().x != finalI || optionsPanel.getCurrentPoint().y != finalJ) {
                            addButton(finalI, finalJ);
                            optionsPanel.setCurrentIndexes(finalI, finalJ);
                        } else {
                            optionsPanel.setVisible(false);
                        }
                    }
                });
            }
        }
        baseBackColor = manager.getMiddleComponent(0, 0).getComponent().getBackground();
        addPanels();
    }
    protected void addPanels() {
        panel.add(optionsPanel.getPanel());
        panel.add(manager.getCmp());
    }

    public abstract void createOptionsPanel();

    public void removeContent() {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                var button = manager.getMiddleComponent(i, j).getComponent();
                button.setContent(Card.EMPTY_DATA_CONTENT);
                if (!button.isEnabled()) {
                    button.setEnabled(true);
                }
            }
        }
    }



    public void applyContent(ArrayList<AbstractMap.SimpleEntry<Vector2, String>> content) {
        removeContent();
        for (var pair : content) {
            manager.getMiddleComponent(pair.getKey().x, pair.getKey().y).getComponent().setContent(pair.getValue());
        }
    }

    public void applyContent(AbstractMap.SimpleEntry<Vector2, String>... content) {
        removeContent();
        applyContent(new ArrayList<>(Arrays.asList(content)));
    }

    public void initializeOptionsButtonPanelData(ArrayList<String> optionsPanelData) {
        optionsPanel.initializeButtonsData(optionsPanelData);
    }


    public void addOptionsListener(int index, ActionListener listener) {
        optionsPanel.addOptionsPanelCommand(index, listener);
    }

    public Vector2 getCurrentClickedIndexes() {
        return optionsPanel.getCurrentPoint();
    }


    public void setDisabledIndexes(ArrayList<Vector2> indexes) {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                manager.getMiddleComponent(i, j).getComponent().setEnabled(true);
            }
        }
        for (var index : indexes) {
            if (!index.isOutOfRange(maxIndex, maxIndex)) {
                manager.getMiddleComponent(index.x, index.y).getComponent().setEnabled(false);
            }
        }

    }

    public void setDisabledIndexes(Vector2... indexes) {
        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));

    }

    public void colorButtons(Vector2... indexes) {
        colorButtons(new ArrayList<>(Arrays.asList(indexes)));

    }

    public void colorButtons(ArrayList<Vector2> indexes) {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                manager.getMiddleComponent(i, j).getComponent().setBackground(baseBackColor);
            }
        }
        for (var index : indexes) {
            if (!index.isOutOfRange(maxIndex, maxIndex)) {
                manager.getMiddleComponent(index.x, index.y).getComponent().setBackground(secondBackColor);
            }
        }
    }


    public JPanel getPanel() {
        return generalManager;
    }

    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return manager;
    }

    private void addButton(int xindex, int yindex) {
        optionsPanel.getPanel().setVisible(true);
        var changeX = optionsPanel.getPercentFilledSizeX();
        var changeY = optionsPanel.getPercentFilledSizeY();
        int leftpercent = (int) (((double) (xindex + 0.5) / maxIndex) * 100 / changeX);
        int rightpercent = (int) (100 / changeX) - weight - leftpercent;//30 to waga

        int upprocent = (int) (((double) (yindex + 0.5) / maxIndex) * 300 / changeY);
        int bottomprocent = (int) (300 / changeY) - weight - upprocent;

        if (rightpercent < 0) {
            rightpercent += weight;
            leftpercent -= weight;
        }
        if (bottomprocent < 0) {
            bottomprocent += weight;
            upprocent -= weight;
        }
        optionsPanel.getPanel().addSpace(leftpercent, ComponentPanelMenager.Side.LEFT);
        optionsPanel.getPanel().addSpace(rightpercent, ComponentPanelMenager.Side.RIGHT);
        optionsPanel.getPanel().addSpace(upprocent, ComponentPanelMenager.Side.TOP);
        optionsPanel.getPanel().addSpace(bottomprocent, ComponentPanelMenager.Side.BOTTOM);

    }

}
