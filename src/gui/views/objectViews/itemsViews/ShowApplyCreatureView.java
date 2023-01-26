package gui.views.objectViews.itemsViews;

import gui.card.DoubleArrowPanel;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.IOverallFactory;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowApplyCreatureView extends ShowSmallView {
    private ArrayList<AbstractCustomButton> applyButtons = new ArrayList<>();
    private DefaultCustomMenuMenager manager1 =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL, 30);
    private DefaultCustomMenuMenager manager2 =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL, 30);

    public ShowApplyCreatureView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize() {
        initialize(4);
        initializeContent();
        arrowPanel.updateSwitchingButtons();
        getCancelButton().getCustomUI().setOffSet(6);
        initializeSetPanel(0,2, manager1);
        initializeSetPanel(2,4, manager2);
        manager1.addMiddleComponent(cards.get(0).getPanel(), 0, 20);
        manager1.addMiddleComponent(cards.get(1).getPanel(), 0, 20);
        manager1.getMiddleComponent(0, 0).addSpace(1);
        manager1.getMiddleComponent(0, 1).addSpace(1);
        manager2.addMiddleComponent(cards.get(2).getPanel(), 0, 20);
        manager2.addMiddleComponent(cards.get(3).getPanel(), 0, 20);
        manager2.getMiddleComponent(0, 0).addSpace(1);
        manager2.getMiddleComponent(0, 1).addSpace(1);
        manager.getMainComponent(0).changeContent(manager1.getCmp());
        manager.getMainComponent(1).changeContent(manager2.getCmp());
        updateContent();


    }

    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, Math.min(maxSideIndex, dataSize));


        for (var button : applyButtons) {
           button.setVisible(true);
        }
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                applyButtons.get(i).setVisible(false);
            }
        }
    }

    private void initializeSetPanel(int number,int end, DefaultCustomMenuMenager man) {
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        man.addMainComponent(12);
        man.addMainComponent(3);
//        manager.addMainComponent(4);
        for (int i = number; i < end; i++) {
            var button = factory.getFactory().createButton("APPLY", null);
            button.getCustomUI().setOffSet(4);
            applyButtons.add(button);
            man.addMiddleComponent(button, 1, 10);
            man.getMiddleComponent(1, i-number).addSpace(5);
            int finalI = i;
            button.addActionListener(e -> {
                clickedIndex = maximumumElements * currentSide + finalI;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.APPLY)) {
                    System.out.println("sfsdfsdsd");
                    listenerHashMap.get(clickedIndex).get(ButtonType.APPLY).actionPerformed(e);
                }
            });
        }
    }
}
