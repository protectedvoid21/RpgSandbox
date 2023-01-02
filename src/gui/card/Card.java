package gui.card;

import game.equipment.Item;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Card implements SwitchableComponent {
    static final public String EMPTY_DATA_CONTENT = "";
    private AbstractCard activeCard = new EmptyCard();
    private Map<CardTypes, AbstractCard> allCards = new HashMap<>();


    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, OVERALL}

    private static Map<CardTypes, Integer> cardSideIndexes = Map.of(CardTypes.OVERALL, 0, CardTypes.ATTRIBUTE, 1,
            CardTypes.WEAPONS, 4, CardTypes.EFFECTS, 3, CardTypes.ARMOR, 2);

    private ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>> titleSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;

    private DefaultCustomMenuMenager seriesPanel;
    private GuiFactory factory;
    private int currentAttrSide = 1;

    public Card(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<ArrayList<String>> dataMap, GuiFactory factory) {
        this.factory = factory;
        allCards.put(CardTypes.ATTRIBUTE, new AttributesCard(titleIconPathName, dataMap, factory));
        allCards.put(CardTypes.ARMOR, new DetailButtonsCard(titleIconPathName, dataMap, factory));
        allCards.put(CardTypes.EFFECTS, new DetailButtonsCard(titleIconPathName, dataMap, factory));
        allCards.put(CardTypes.WEAPONS, new DetailButtonsCard(titleIconPathName, dataMap, factory));
        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        initSeriesPanel(titleSeries, 0, 3);
        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 7);
        initSeriesPanel(createArrowComponentSeries(), 2, 2);
        initializeTitle();
        updateContent();
        rightArrows.setSwitchableComponent(this);
        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }

    private CardTypes convertIntToType(int value){
        for (var key : cardSideIndexes.keySet()){
            if (cardSideIndexes.get(key)==value){
                return key;
            }
        }
        return CardTypes.OVERALL;
    }

    public void updateContent(){

        activeCard.reset();
        activeCard = allCards.get(convertIntToType(currentAttrSide));
        seriesPanel.getMainComponent(1).changeContent(activeCard.getMenager());
        leftArrows.setSwitchableComponent(activeCard);
        updateTitle();
    }


    @Override
    public void switchSide(DoubleArrowPanel.Side side) {
        if (isSwitchingSidePossible(side)) {
            switch (side) {
                case LEFT -> currentAttrSide--;
                case RIGHT -> currentAttrSide++;
            }
            updateContent();
        }
    }

    @Override
    public boolean isSwitchingSidePossible(DoubleArrowPanel.Side side) {
        boolean status = false;
        switch (side) {
            case LEFT -> status = currentAttrSide > 0;
            case RIGHT -> status = currentAttrSide < cardSideIndexes.size()-1;
        }
        return status;
    }


    private void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    private ComponentsSeries createArrowComponentSeries() {
        var arrowsManager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory, activeCard);///
        leftArrows.setSpace(5);
        rightArrows = new DoubleArrowPanel(factory, activeCard);
        rightArrows.setSpace(5);
        arrowsManager.addOption(leftArrows.getPanel(), 5);
        arrowsManager.addOption(rightArrows.getPanel(), 5);
        return arrowsManager;
    }


    public void setBackgroundImage(String path) throws IOException {
        seriesPanel.getCmp().setBackgroundImage(path);
    }

    public void setBackgroundColor(Color color) {
        seriesPanel.setBackground(color);
    }

    public JPanel getPanel() {
        return seriesPanel.getCmp();
    }


    public void setUniformFont() {
        for (var type : CardTypes.values()) {
            if (allCards.containsKey(type)) {
                allCards.get(type).setUniformForm();
            }
        }
    }

    public void setVisibility(boolean value) {
        setAspectVisible(activeCard.getContentMenager().getComponentsList(), value);
        setAspectVisible(new ArrayList<>(titleSeries.getComponentsList().stream().map(cmp -> cmp.getComponent()).toList()), value);

    }

    public static <T extends JComponent & IContentCustomUICmp> void setAspectVisible(ArrayList<T> container, boolean value) {
        for (var cmp : container) {
            cmp.setVisible(cmp.getContent().isEmpty() ? false : value);
        }
    }


    public void initializeTitle() {//zmienia sie
        factory.setLabelType(GuiFactory.LabelType.ICON);
        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(EMPTY_DATA_CONTENT)), 30);
        titleSeries.getOption(0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
        titleSeries.getOption(0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
        titleSeries.getOption(0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

        factory.setLabelType(GuiFactory.LabelType.NORMAL);
        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(EMPTY_DATA_CONTENT)), 30);
        titleSeries.getOption(1).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
        titleSeries.getOption(1).addSpace(1, ComponentPanelMenager.Side.LEFT);
        titleSeries.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM);

    }


    protected void updateTitle() {//zmienia sie
        titleSeries.getOption(0).getComponent().setContent(activeCard.getFirstTitleContent());
        titleSeries.getOption(1).getComponent().setContent(activeCard.getSecondTitleContent());
    }
}
