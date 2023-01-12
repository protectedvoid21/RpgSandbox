package gui.views.pickers;

import gui.card.DoubleArrowPanel;
import gui.card.SwitchableComponent;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentsSeries;
import gui.menu.CustomMenuMenager;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemPicker implements SwitchableComponent {
    private DoubleArrowPanel arrows;
    private DefaultCustomMenuMenager menager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private ArrayList<String> items = new ArrayList<>();
    private AbstractCustomLabel label;
    private int currentSide = 0;

    public ItemPicker(GuiFactory factory) {
        arrows = new DoubleArrowPanel(factory, this);
        menager.addMainComponent(10);
        menager.addMainComponent(5);
        menager.addMiddleComponent(arrows.getPanel(), 1, 10);
        menager.getMiddleComponent(1, 0).addSpace(1);
        factory.setLabelType(GuiFactory.LabelType.ICON);
        label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        menager.addMiddleComponent(label, 0, 10);
        menager.getMiddleComponent(0, 0).addSpace(1);
//        menager.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 20);
        menager.getCmp().setHasUniqueColor(true);
        menager.getCmp().setBackground(new Color(0x830F2972, true));
        arrows.updateSwitchingButtons();


    }

    @Override
    public void switchSide(DoubleArrowPanel.Side side) {
        if (isSwitchingSidePossible(side)) {
            switch (side) {
                case LEFT -> currentSide--;
                case RIGHT -> currentSide++;
            }
            updateContent();

        }
    }

    private void updateContent() {
        label.setContent(items.get(currentSide));
    }

    public void uploadData(ArrayList<String> dataList) {
        this.items = dataList;
        currentSide = 0;
        arrows.updateSwitchingButtons();
        updateContent();
    }

    @Override
    public boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
        boolean status = false;
        switch (side) {
            case LEFT -> status = currentSide > 0;
            case RIGHT -> status = currentSide < items.size() - 1;
        }
        return status;
    }

    public JPanel getPanel(){
        return menager.getCmp();
    }
    public int getCurrentIndex(){
        return currentSide;
    }
}
