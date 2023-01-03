package gui.card;

import game.equipment.Item;
import gui.customComponents.*;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.CustomMenuMenager;
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

//    private AbstractCard minkiCard;

//    public enum Mode {MINKI, DETAIL}

    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, OVERALL, MOUNT}

    private static ArrayList<CardTypes> cardSideIndexes = new ArrayList<>(Arrays.asList(CardTypes.OVERALL,
            CardTypes.ATTRIBUTE,
            CardTypes.WEAPONS, CardTypes.EFFECTS, CardTypes.ARMOR, CardTypes.MOUNT));

    private ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>> titleSeries =
            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;
    //    private ComponentPanelMenager showDetailViewButton;
//    private ComponentsSeries arrowMenager;

    private DefaultCustomMenuMenager seriesPanel;
    private GuiFactory factory;
    private int currentAttrSide = 0;
    //    private ArrayList<ArrayList<String>> minkidataMap;//cos wiekszego
//    private AbstractMap.SimpleEntry<String, String> titleIconPathName;//cos wiekszego
//    private Mode currentMode;

//    private HashMap<CardTypes, AbstractMap.SimpleEntry<ArrayList<String>, ArrayList< >>>

    public Card(GuiFactory factory) {
        this.factory = factory;
//        this.minkidataMap = dataMap;
//        this.titleIconPathName = titleIconPathName;
//        initializeWholeCard();

//        minkiCard = new MiniOverallCard(factory);
//        minkiCard.initializeCardData(minkititleIconPathName, minkidataMap);

        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                ComponentsSeries.ComponentsDimension.HORIZONTAL);
        initSeriesPanel(titleSeries, 0, 3);
        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 7);
        initSeriesPanel(createArrowComponentSeries(), 2, 2);

//        createDetailViewButtonMenager();

        initializeWholeCard();
        initializeTitle();
        rightArrows.setSwitchableComponent(this);
//        setMode(Mode.MINKI);
//        switchSide(CardTypes.OVERALL);
//        updateContent();
        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }


//    public void setMode(Mode mode) {
//        currentMode = mode;
//        switch (mode) {
//            case MINKI -> {
//                seriesPanel.getMiddleComponent(2, 0).changeContent(showDetailViewButton);
//                activeCard = minkiCard;
//                seriesPanel.getMainComponent(1).changeContent(activeCard.getMenager());
//                updateTitle();
//
//            }
//            case DETAIL -> {
//                seriesPanel.getMiddleComponent(2, 0).changeContent(arrowMenager);
//                switchSide(cardSideIndexes.get(0));
//            }
//        }
//    }

    public void initializeWholeCard() {
//        allCards = cards;
//        activeCard = allCards.get(0);

        allCards.put(CardTypes.ATTRIBUTE, new AttributesCard(factory));
        allCards.put(CardTypes.ARMOR, new DetailButtonsCard(factory));
        allCards.put(CardTypes.MOUNT, new DetailButtonsCard(factory));
        allCards.put(CardTypes.EFFECTS, new DetailButtonsCard(factory));
        allCards.put(CardTypes.WEAPONS, new DetailButtonsCard(factory));
        var map = new ArrayList<ActionListener>();

        for (var key : cardSideIndexes.subList(1, cardSideIndexes.size())) {
            map.add(e -> switchSide(key));
        }
        allCards.put(CardTypes.OVERALL, new OverallCard(factory, map));
    }

    //    private CardTypes convertIntToType(int value) {
//        return cardSideIndexes.get(value);
//    }
    public void uploadNewData(HashMap<CardTypes, CardContentDataSet > newData){
        System.out.println(allCards);
        for (var type : newData.keySet()){
            System.out.println(type);
            allCards.get(type).initializeCardData(newData.get(type));
        }
        switchSide(CardTypes.OVERALL);
    }


//    public void initializeContentOfCard(Card.CardTypes type, ArrayList<ArrayList<String>> dataMap) {
//        allCards.get(type).initializeCardData(dataMap);
//    }
//
//    public void initializeTitleOfCard(Card.CardTypes type, AbstractMap.SimpleEntry<String, String> titleIconPathName) {
//        allCards.get(type).initializeCardData(titleIconPathName);
//    }

    public void updateContent() {

        activeCard.reset();
        activeCard = allCards.get(cardSideIndexes.get(currentAttrSide));
        seriesPanel.getMainComponent(1).changeContent(activeCard.getMenager());
        leftArrows.setSwitchableComponent(activeCard);
        updateTitle();
    }

    public void switchSide(CardTypes cardType) {
        currentAttrSide = cardSideIndexes.indexOf(cardType);
        updateContent();
        rightArrows.updateSwitchingButtons();
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
            case RIGHT -> status = currentAttrSide < cardSideIndexes.size() - 2;
        }
        return status;
    }


    private void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    private ComponentsSeries createArrowComponentSeries() {
        var arrowMenager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory, activeCard);///
        leftArrows.setSpace(5);
        rightArrows = new DoubleArrowPanel(factory, activeCard);
        rightArrows.setSpace(5);
        arrowMenager.addOption(leftArrows.getPanel(), 5);
        arrowMenager.addOption(rightArrows.getPanel(), 5);
        return arrowMenager;
    }

//    private void createDetailViewButtonMenager() {
//        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
//        var button = factory.createButton("DETAIL VIEW", null);
//        button.addActionListener(e -> setMode(Mode.DETAIL));
//        showDetailViewButton = new ComponentPanelMenager(button);
//        showDetailViewButton.addSpace(20, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
//        showDetailViewButton.addSpace(12, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
//
//
//        ///dodac listenera
//    }


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

    public static <T extends JComponent & IContentCustomUICmp> void setAspectVisible(ArrayList<T> container,
                                                                                     boolean value) {
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
