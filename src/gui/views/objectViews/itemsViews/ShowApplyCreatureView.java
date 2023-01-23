package gui.views.objectViews.itemsViews;

import gui.card.DoubleArrowPanel;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.IOverallFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowApplyCreatureView extends ShowSmallView{
    private ArrayList<AbstractCustomButton> applyButtons = new ArrayList<>();
    public ShowApplyCreatureView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize() {
        super.initialize();
        initializeSetPanel(2);
        var cmp = manager.getMainComponent(1).getComponent();
        var cmp2 = manager.getMainComponent(2).getComponent();
        manager.getMainComponent(1).changeContent(cmp2);
        manager.getMainComponent(2).changeContent(cmp);

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
            button.addActionListener(e -> {
                clickedIndex = maximumumElements * currentSide + finalI;
                if (listenerHashMap.containsKey(finalI) && listenerHashMap.get(finalI).containsKey(ButtonType.APPLY)) {
                    listenerHashMap.get(finalI).get(ButtonType.APPLY).actionPerformed(e);
                }
            });
        }
    }
}
