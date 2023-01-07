package gui.card.fullCards.specificCards;

import gui.card.CardContentDataSet;
import gui.card.SharedCmpsFont;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OnlyVisibleCard extends BaseCard {
    private DefaultCustomMenuMenager<JComponent> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    protected ArrayList<AbstractCustomLabel> labelList = new ArrayList<>();
    private int maximumElementSize;
    private CardContentDataSet currentData = new CardContentDataSet();
    private AbstractCustomButton button;


    public OnlyVisibleCard(GuiFactory factory, int elementsSize) {
        super(factory);
        maximumElementSize = elementsSize;
    }

    public void uploadNewData(CardContentDataSet data) {
        leftTitleComponent.getComponent().setContent(data.titlePath);
        leftTitleComponent.getComponent().setContent(data.titleContent);
        for (int i = 0; i < labelList.size(); i++) {
            var cnt = data.content.get(i / 2).get(i % 2);
            var lbl = labelList.get(i);
            if (lbl.getContent() != cnt) {
                lbl.setContent(cnt);
            }
        }
    }


    @Override
    public void setUniformFont() {
        var list = new ArrayList<AbstractCustomLabel>();
        for (var x : labelList) {
            list.add(x);
        }
        SharedCmpsFont.setUniformFont(list);
    }

    @Override
    public void setVisibility(boolean value) {
        setAspectVisible(new ArrayList<>(Arrays.asList(leftTitleComponent.getComponent(), rightTitleComponent.getComponent())), value);
    }

    @Override
    public void initialize() {
        initializeCard();
        initializeContent();
    }

    protected void initializeContent() {
        for (int i = 0; i < maximumElementSize; i++) {
            factory.setLabelType(GuiFactory.LabelType.ICON);
            var label = factory.createLabel(Card.EMPTY_DATA_CONTENT);
            factory.setLabelType(GuiFactory.LabelType.NORMAL);
            var label2 = factory.createLabel(Card.EMPTY_DATA_CONTENT);

            var newPanel =
                    new ComponentsSeries<ComponentPanelMenager<JComponent>>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

            for (var panel : Arrays.asList(label, label2)) {
                newPanel.addOption(new ComponentPanelMenager<>(panel), 2);
            }
            menager.addMiddleComponent(newPanel, i / 2, 20);
            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.LEFT);
            newPanel.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);

            menager.getMiddleComponent(i / 2, i % 2).addSpace(1);
            labelList.add(label);
            labelList.add(label2);
        }

    }

    protected void initializeCard() {
        final int modulo = maximumElementSize % 2;
        final int div = maximumElementSize / 2;

        int rangeValue = modulo == 1 ? div + 1 : div;
        for (int i = 0; i < rangeValue; i++) {
            menager.addMainComponent(10);
        }
        if (modulo == 1) {
            menager.getMainComponent(div).addSpace(5, ComponentPanelMenager.Side.LEFT,
                    ComponentPanelMenager.Side.RIGHT);
        }
        seriesPanel.getMiddleComponent(1, 0).changeContent(menager.getCmp());
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        button = factory.createButton("SHOW", null);
        initSeriesPanel(button, 2, 2);

        seriesPanel.getMiddleComponent(2, 0).addSpace(10, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        seriesPanel.getMiddleComponent(2, 0).addSpace(3, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
    }

    public AbstractCustomButton getButton(){
        return button;
    }
}
