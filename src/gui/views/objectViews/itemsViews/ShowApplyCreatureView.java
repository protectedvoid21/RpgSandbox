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
        super.initialize();
        getCancelButton().getCustomUI().setOffSet(6);
        initializeSetPanel(2, manager1);
        initializeSetPanel(2, manager2);
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


    }

    private void initializeSetPanel(int number, DefaultCustomMenuMenager man) {
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        man.addMainComponent(12);
        man.addMainComponent(3);
//        manager.addMainComponent(4);
        for (int i = 0; i < number; i++) {
            var button = factory.getFactory().createButton("APPLY", null);
            button.getCustomUI().setOffSet(4);
            applyButtons.add(button);
            man.addMiddleComponent(button, 1, 10);
            man.getMiddleComponent(1, i).addSpace(5);
            int finalI = i;
            button.addActionListener(e -> {
                clickedIndex = maximumumElements * currentSide + finalI;
                if (listenerHashMap.containsKey(finalI) && listenerHashMap.get(finalI).containsKey(ButtonType.APPLY)) {
                    listenerHashMap.get(finalI).get(ButtonType.APPLY).actionPerformed(e);
                }
            });
        }
    }
}
