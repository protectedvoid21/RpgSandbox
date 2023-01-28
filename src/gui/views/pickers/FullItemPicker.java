package gui.views.pickers;

import gui.card.DoubleArrowPanel;
import gui.card.SwitchableComponent;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FullItemPicker implements SwitchableComponent, PanelContainer {
    public enum LabelType {WEAPON, ARMOR, MOUNT}

    private final HashMap<Integer, LabelType> indexmap = new HashMap<>();
    private final DoubleArrowPanel arrows;
    private final DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private HashMap<LabelType, ItemPicker> items = new HashMap<>();
    private HashMap<LabelType, String> labelPaths = new HashMap<>();
    private final AbstractCustomLabel label;
    private int currentSide = 0;

    public FullItemPicker(GuiFactory factory) {
        indexmap.put(0, LabelType.WEAPON);
        indexmap.put(1, LabelType.ARMOR);
        indexmap.put(2, LabelType.MOUNT);

        arrows = new DoubleArrowPanel(factory, this);

        for(var num : Arrays.asList(8,12, 4)){
            menager.addMainComponent(num);
        }
        for (var item : LabelType.values()){
            items.put(item, new ItemPicker(factory));
        }
        label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
        menager.addMiddleComponent(label, 0, 10,30);
        menager.addMiddleComponent(arrows.getPanel(), 2, 10,30);
        menager.addMiddleComponent(items.get(LabelType.WEAPON).getPanel(), 1, 10);
        menager.getMiddleComponent(0, 0).addSpace(1);
        menager.getMiddleComponent(2, 0).addSpace(1);
        menager.getMiddleComponent(1, 0).addSpace(1, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);
        factory.setLabelType(GuiFactory.LabelType.ICON);
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
        return items.getOrDefault(type, null);
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

    public ComponentPanelMenager getPanel() {
        return menager.getCmp();
    }

    public int getCurrentIndex() {
        return currentSide;
    }
}
