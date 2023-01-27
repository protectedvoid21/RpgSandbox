package gui.views.pickers;

import gui.card.DoubleArrowPanel;
import gui.card.SwitchableComponent;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.PanelContainer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ItemPicker implements SwitchableComponent, PanelContainer {
    private final DoubleArrowPanel arrows;
    protected DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private ArrayList<String> items = new ArrayList<>();
    private final AbstractCustomLabel label;
    protected int currentSide = 0;
    private CustomLambdaExpression leftListener = () -> {
    };
    private CustomLambdaExpression rightListener = () -> {
    };

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
            switch (side) {
                case LEFT -> leftListener.apply();
                case RIGHT -> rightListener.apply();
            }
        }
    }

    private void updateContent() {
        if (currentSide >= -1) {
            label.setContent(currentSide >= 0 && items.size()>currentSide ? items.get(currentSide) : "");
        }
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

    public ComponentPanelMenager getPanel() {
        return menager.getCmp();
    }

    public int getCurrentIndex() {
        return currentSide;
    }

    public void setCurrentIndex(int value) {
        currentSide = value;
        arrows.updateSwitchingButtons();
        updateContent();
    }

    public void addListenerToPicker(DoubleArrowPanel.Side side, CustomLambdaExpression expression) {
        switch (side) {
            case LEFT -> leftListener = expression;
            case RIGHT -> rightListener = expression;
        }
    }
}
