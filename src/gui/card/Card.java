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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Card extends BaseCard implements SwitchableComponent, ICancelCard {
    static final public String EMPTY_DATA_CONTENT = "";

    private boolean hasCancelButton = false;
    private AbstractCustomButton cancelButton = null;

    private AbstractCard activeCard = new EmptyCard();
    protected Map<CardTypes, AbstractCard> allCards = new HashMap<>();
    private AttributesCard equipmentCard = new EntriesAttributesCard(factory);

    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, OVERALL, MOUNT}

    protected static ArrayList<CardTypes> cardSideIndexes = new ArrayList<>(Arrays.asList(CardTypes.OVERALL,
            CardTypes.ATTRIBUTE,
            CardTypes.WEAPONS, CardTypes.EFFECTS, CardTypes.ARMOR, CardTypes.MOUNT));
    private ComponentsSeries<ComponentPanelMenager<JComponent>> arrowMenager;
    private ComponentPanelMenager<AbstractCustomButton> exitButton;
    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;
    private int currentAttrSide = 0;
//    private int currentEqSide = 0;

    @Override
    public AbstractCustomButton getCancelButton() {
        return cancelButton;
    }

    @Override
    public void setCancelButtonStatus(boolean status) {
        hasCancelButton = status;
        showCancelButton(hasCancelButton);
    }

    private void showCancelButton(boolean status) {
        seriesPanel.getMainComponent(3).setVisible(hasCancelButton == false ? false : status);
    }

    private void createCancelButton() {
        seriesPanel.addMainComponent(1);
        cancelButton = factory.createButton("CANCEL", e -> seriesPanel.getCmp().setVisible(false));
        seriesPanel.addMiddleComponent(cancelButton, 3, 10);
        seriesPanel.getMiddleComponent(3, 0).addSpace(10, ComponentPanelMenager.Side.LEFT,
                ComponentPanelMenager.Side.RIGHT);
    }


    public Card(GuiFactory factory) {
        super(factory);

//        createArrowComponentSeries();
//        initSeriesPanel(arrowMenager, 2, 4);
//
//        initializeWholeCard();
//        createCancelButton();
//        setCancelButtonStatus(false);
//        rightArrows.setSwitchableComponent(this);
    }

    public void initialize() {
        createArrowComponentSeries();
        initSeriesPanel(arrowMenager, 2, 4);

        initializeWholeCard();
        createCancelButton();
        setCancelButtonStatus(false);
        rightArrows.setSwitchableComponent(this);
    }

    protected void detailButtonMethod(DetailButtonsCard card) {
        equipmentCard.initializeCardData(card.getData().eqData.get(0));
        updateContent(equipmentCard);
        arrowMenager.getOption(1).changeContent(exitButton);//yyyyto fix
        showCancelButton(false);
    }

    protected abstract DetailButtonsCard createDetailButton();


    protected void initializeDetailButtonsCardPart(CardTypes type) {
        System.out.println("cokolwiek");
        var but = createDetailButton();
        but.initializeCard();
        but.getDetailButton(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                eqaCard = activeCard;
                detailButtonMethod(but);
            }
        });
        allCards.put(type, but);//tutaj trzeba buttonom nadac komendy, CardContent bedzie mogl zawierac CardContentn
        // np z armorami
    }

    private void initializeWholeCard() {
        equipmentCard.initializeCard();
        var attrCard =  new EntriesAttributesCard(factory);
        attrCard.initializeCard();
        allCards.put(CardTypes.ATTRIBUTE,attrCard);
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.MOUNT, CardTypes.EFFECTS, CardTypes.WEAPONS)) {
            initializeDetailButtonsCardPart(type);
        }
        var map = new ArrayList<ActionListener>();

        for (var key : cardSideIndexes.subList(1, cardSideIndexes.size())) {
            map.add(e -> switchSide(key));
        }
        allCards.put(CardTypes.OVERALL, new OverallCard(factory, map));
    }

    public void uploadNewData(HashMap<CardTypes, CardContentDataSet> newData) {
        for (var type : newData.keySet()) {
            allCards.get(type).initializeCardData(newData.get(type));
        }
        switchSide(CardTypes.OVERALL);
    }

    public void updateContent(AbstractCard newActiveCard) {

        activeCard.reset();//pierdziele zawsze niech resetuje jest prosciej
        activeCard = newActiveCard;
        seriesPanel.getMainComponent(1).changeContent(activeCard.getMenager());
        leftArrows.setSwitchableComponent(activeCard);
        updateTitle();
    }


    public void updateContent() {
        updateContent(allCards.get(cardSideIndexes.get(currentAttrSide)));
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


    protected void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    private void createArrowComponentSeries() {
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        exitButton = new ComponentPanelMenager<>(factory.createButton("exit", null));
        exitButton.addSpace(5);

        exitButton.getComponent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrowMenager.getOption(1).changeContent(rightArrows.getPanel());//to fix
                showCancelButton(hasCancelButton);
                updateContent();
            }
        });

        arrowMenager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory, activeCard);///
        leftArrows.setSpace(5);
        rightArrows = new DoubleArrowPanel(factory, activeCard);
        rightArrows.setSpace(5);

        arrowMenager.addOption(new ComponentPanelMenager<>(leftArrows.getPanel()), 5);
        arrowMenager.addOption(new ComponentPanelMenager<>(rightArrows.getPanel()), 5);
    }


    @Override
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


    protected void updateTitle() {//zmienia sie
        titleSeries.getOption(0).getComponent().setContent(activeCard.getFirstTitleContent());
        titleSeries.getOption(1).getComponent().setContent(activeCard.getSecondTitleContent());
    }
}
