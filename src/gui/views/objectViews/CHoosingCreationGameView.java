package gui.views.objectViews.creatureViews;

import gui.card.CardContentDataSet;
import gui.card.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.views.gamePanel.CreatorPanel;
import gui.views.objectViews.AllObjectsView;
import gui.views.objectViews.CreatorGameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CHoosingCreationGameView extends AllObjectsView {
    protected ArrayList<CreatorPanel> data = new ArrayList<>();
    private ArrayList<AbstractCustomButton> applyButtons = new ArrayList<>();


    public CHoosingCreationGameView(IOverallFactory factory) {
        super(factory);

    }
//
//    @Override
//    protected void initialize(int maximumumElements) {
//        int maxindex = (maximumumElements + 1) / 2;
//        for (int i = 0; i < maxindex; i++) {
//            manager.addMainComponent(24);
//        }
//    }

    public void initialize() {
        initialize(2);
        initializeSetPanel(2);
        var cmp = manager.getMainComponent(1).getComponent();
        var cmp2 = manager.getMainComponent(2).getComponent();

//        createDownPanel(2);
        initializeContent();
        for (int i =0; i<11; i++){
            var x = new CreatorPanel(factory, 10);
            x.initialize();

            x.setWholePanelDisabled();
            data.add(x);
        }
        this.manager.setBackground(new Color(0x367045));
        this.manager.setHasUniqueColor(true);
        updateContent();
        arrowPanel.updateSwitchingButtons();
        manager.getMainComponent(1).changeContent(cmp2);
        manager.getMainComponent(2).changeContent(cmp);

    }

    public void uploadCards(ArrayList<CreatorPanel> panels){
        this.data = data;
//        for (var d : data){
//            card.getShowButton().addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    clickedIndex = maximumumElements * currentSide + index;
//                    if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.SHOW)) {
//                        listenerHashMap.get(clickedIndex).get(ButtonType.SHOW).actionPerformed(e);
//                    }
//                }
//            });
//        }
    }

    public void initializeSetPanel(int number){
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        manager.addMainComponent(3);
        for (int i = 0; i<number; i++){
            var button = factory.getFactory().createButton("APPLY", null);
            applyButtons.add(button);
            manager.addMiddleComponent(button, 2,10);
            manager.getMiddleComponent(2, i).addSpace(5);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("hah");
                    clickedIndex = maximumumElements * currentSide + finalI;
                    System.out.println(clickedIndex);
//                    System.out.println(listenerHashMap.containsKey(clickedIndex)+"  "+);
                    if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.APPLY)) {
                        listenerHashMap.get(clickedIndex).get(ButtonType.APPLY).actionPerformed(e);
                    }
                }
            });
//            manager.getMiddleComponent(2, 0)
        }
//        manager.addMiddleComponent(factory.getFactory().createButton("APPLY", null), 0, 10);
//        manager.addMiddleComponent(factory.getFactory().createButton("APPLY", null), 0, 10);
    }



    protected ArrayList<? extends Object> getCards(){
        return data;
    }


    @Override
    protected void initializeContent() {
        for (int j = 0; j < 2; j++) {
            var panel = new ComponentPanelMenager<JComponent>(new JPanel());
            manager.addMiddleComponent(panel, 0, 20);
            manager.getMiddleComponent(0, j).addSpace(1);
            manager.getMiddleComponent(0, j).addSpace(2, ComponentPanelMenager.Side.TOP);
        }

    }

    public void uploadData(ArrayList<CreatorPanel> data) {
        this.data = data;
        currentSide = 0;
        updateContent();
    }

    @Override
    public ArrayList<? extends CreatorPanel> getData() {
        return data;
    }

    public AbstractCustomButton getApplyButton(int index){
        return applyButtons.get(index);
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);

        int currentIndex = 0;
        System.out.println(data);
        for (var key : sublist) {
            manager.getMiddleComponent(0, currentIndex).changeContent(key.getPanel());
            key.getPanel().setVisible(true);
            currentIndex++;
        }
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                manager.getMiddleComponent(0, i).getComponent().setVisible(false);
            }
        }

    }

}
