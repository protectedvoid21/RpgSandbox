package gui.views.gamePanel;

import gui.card.IOverallFactory;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.menu.ICustomBackgorund;
import gui.views.BackgroundView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public class MainGamePanel extends BackgroundView {
    private Color baseBackColor;
    private Color secondBackColor = Color.YELLOW;
    private ComponentPanelMenager generalManager;
    private JPanel panel = new JPanel();
    private OptionsPanel optionsPanel;
    //    private DefaultCustomMenuMenager customPanelAttackChoser =
//            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL, 30);
    private IOverallFactory factory;
    private OverlayLayout layout;
    //    private int maxxs;
//    private int maxyy;
    private int maxIndex;
    final private int weight;
    public DefaultCustomMenuMenager<AbstractCustomButton> manager =
            new DefaultCustomMenuMenager<AbstractCustomButton>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    public MainGamePanel(IOverallFactory factory, int size) {
        layout = new OverlayLayout(panel);
        this.weight = 400 / size;
        panel.setLayout(layout);
        this.maxIndex = size;
        this.factory = factory;
        optionsPanel = factory.createOptionsPanel();
        optionsPanel.initialize(weight);
        optionsPanel.setBorderColor(Color.RED);
        generalManager = new ComponentPanelMenager(panel);
        intiializeOptionsPanelData(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/rightarrowdisabled.png",
                        "2"), new AbstractMap.SimpleEntry<>("src/gui/snowman.png", "0"),
                new AbstractMap.SimpleEntry<>("/gui/playerimage.png", "1"), new AbstractMap.SimpleEntry<>(
                        "src/gui/playerimage.png", "2"), new AbstractMap.SimpleEntry<>(
                        "src/gui/playerimage.png", "3"))));
//        optionsPanel.setNonVisibleButtons(1,3);
        factory.getFactory().setButtonFactory(new BasicButton());
        factory.getFactory().setButtonType(GuiFactory.ButtonType.ICON);
        for (int i = 0; i < maxIndex; i++) {
            manager.addMainComponent(5);
            for (int j = 0; j < maxIndex; j++) {
                var but = factory.getFactory().createButton("src/gui/witch.png", null);
                but.setHasDisabledColor(true);
                but.setSecondDisabledColor(Color.YELLOW);
                manager.addMiddleComponent(but, i, 5);
                int finalI = i;
                int finalJ = j;
                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optionsPanel.getCurrentX() != finalI || optionsPanel.getCurrentY() != finalJ) {
                            addButton(finalI, finalJ);
                            optionsPanel.setCurrentIndexes(finalI, finalJ);
                        }else{
                            optionsPanel.setVisible(false);
                        }
                    }
                });
            }
        }
        baseBackColor = manager.getMiddleComponent(0, 0).getComponent().getBackground();
        panel.add(optionsPanel.getPanel());
        panel.add(manager.getCmp());
    }

    public void intiializeOptionsPanelData(ArrayList<AbstractMap.SimpleEntry<String, String>> optionsPanelData){
        optionsPanel.initializeData(optionsPanelData);
    }




    public void addOptionsListener(int index, ActionListener listener){
        optionsPanel.addOptionsPanelCommand(index, listener);
    }
    public AbstractMap.SimpleEntry<Integer, Integer> getCurrentClickedIndexes(){
        return new AbstractMap.SimpleEntry<>(optionsPanel.getCurrentX(), optionsPanel.getCurrentY());
    }

    public void setOptionsDisabledIndexes(ArrayList<Integer> indexes) {
        optionsPanel.setDisabledIndexes(indexes);
    }

    public void setOptionsDisabledIndexes(Integer... indexes) {
        optionsPanel.setDisabledIndexes(indexes);
    }

    public void setDisabledIndexes(ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> indexes) {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                manager.getMiddleComponent(i, j).getComponent().setEnabled(true);
            }
        }
        for (var index : indexes) {
            manager.getMiddleComponent(index.getKey(), index.getValue()).getComponent().setEnabled(false);
        }

    }

    public void setDisabledIndexes(AbstractMap.SimpleEntry<Integer, Integer>... indexes) {
        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));

    }

    public void colorButtons(AbstractMap.SimpleEntry<Integer, Integer>... indexes) {
        colorButtons(new ArrayList<>(Arrays.asList(indexes)));

    }

    public void colorButtons(ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> indexes) {
        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex; j++) {
                manager.getMiddleComponent(i, j).getComponent().setBackground(baseBackColor);
            }
        }
        for (var index : indexes) {
            manager.getMiddleComponent(index.getKey(), index.getValue()).getComponent().setBackground(secondBackColor);
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
        var index = optionsPanel.getPercentFilledSize();
        int leftpercent = (int) (((double) (xindex + 0.5) / maxIndex) * 100/index);
        int rightpercent = (int)(100/index) - weight - leftpercent;//30 to waga

        int upprocent = (int) (((double) (yindex + 0.5) / maxIndex) * 300);
        int bottomprocent = (int)(300) - weight - upprocent;

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
