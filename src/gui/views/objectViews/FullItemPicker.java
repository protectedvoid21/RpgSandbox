package gui.views.objectViews;

import game.equipment.Item;
import gui.card.DoubleArrowPanel;
import gui.card.SwitchableComponent;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullItemPicker implements SwitchableComponent {
    public enum LabelType {WEAPON, ARMOR, MOUNT}

    private HashMap<Integer, LabelType> indexmap = new HashMap<>();
    private DoubleArrowPanel arrows;
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<JComponent>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private HashMap<LabelType, ItemPicker> items = new HashMap<>();
//    private ComponentPanelMenager<JComponent> panel;
    private HashMap<LabelType, String> labelPaths = new HashMap<>();
    private AbstractCustomLabel label;
    private int currentSide = 0;

    public FullItemPicker(GuiFactory factory) {

        menager.getCmp().addSpace(4, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        indexmap.put(0, LabelType.WEAPON);
        indexmap.put(1, LabelType.ARMOR);
        indexmap.put(2, LabelType.MOUNT);
        arrows = new DoubleArrowPanel(factory, this);
        menager.addMainComponent(8);
        menager.addMainComponent(12);
        menager.addMainComponent(4);
        for (var item : LabelType.values()){
            items.put(item, new ItemPicker(factory));
        }


        label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        menager.addMiddleComponent(label, 0, 10,30);
        menager.addMiddleComponent(arrows.getPanel(), 2, 10,30);
        menager.addMiddleComponent(items.get(LabelType.WEAPON).getPanel(), 1, 10);
//        menager.addMiddleComponent(new JPanel(), 0, 10);
        menager.getMiddleComponent(0, 0).addSpace(1);
        menager.getMiddleComponent(2, 0).addSpace(1);
        menager.getMiddleComponent(1, 0).addSpace(1, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        factory.setLabelType(GuiFactory.LabelType.ICON);
//        menager.getMiddleComponent(0, 0).addSpace(1);
//        menager.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 10);
//        menager.getCmp().setHasUniqueColor(true);
//        menager.getCmp().setBackground(new Color(0x4359B4));
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
        label.setContent(labelPaths.get(indexmap.get(currentSide)));
        menager.getMiddleComponent(1, 0).changeContent(items.get(indexmap.get(currentSide)).getPanel());

//        panel.changeContent(items.get(indexmap.get(currentSide)).getPanel());
    }

    public void uploadMainPaths(HashMap<LabelType, String> map) {
        this.labelPaths = map;
        reset();
    }

    public void uploadItemPaths(HashMap<LabelType, ArrayList<String>> map) {

        for (var type : LabelType.values()) {
            items.get(type).uploadData(map.containsKey(type) ? map.get(type) : new ArrayList<>());
        }
        reset();
    }
    private void reset(){
        currentSide = 0;
        arrows.updateSwitchingButtons();
        updateContent();
    }

    public ItemPicker getPicker(LabelType type) {
        return items.containsKey(type) ? items.get(type) : null;
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

    public JPanel getPanel() {
        return menager.getCmp();
    }

    public int getCurrentIndex() {
        return currentSide;
    }
}
