package gui.card.fullCards.abstractCards;

import gui.bundle.CustomBundle;
import gui.card.*;
import gui.card.contentCards.AbstractCard;
import gui.card.contentCards.OverallCard;
import gui.card.contentCards.detailCards.TextAreaCard;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.EmptyCard;
import gui.card.contentCards.attributesCards.EntriesAttributesCard;
import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class Card extends BaseCard implements SwitchableComponent, ICancelCard {
    static final public String EMPTY_DATA_CONTENT = "";
    private boolean hasCancelPanel = false;
    private AbstractCustomButton cancelButton = null;

    protected AbstractCard activeCard = new EmptyCard();
    protected LinkedHashMap<CardTypes, AbstractCard<? extends JComponent>> allCards = new LinkedHashMap<>();
    private AttributesCard equipmentCard;
    private TextAreaCard textareaEquipmentCard;

    protected EntriesAttributesCard amwGeneratorCard;

    private AddingButtonCard choserEqCard = null;

    protected HashMap<CardTypes, CardContentDataSet> creatorData = new HashMap<>();

    public enum CardTypes {OVERALL, ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, MOUNT, ITEMS}

    protected ArrayList<CardTypes> cardSideIndexes = new ArrayList<>(Arrays.asList(CardTypes.OVERALL,
            CardTypes.ATTRIBUTE,
            CardTypes.WEAPONS, CardTypes.EFFECTS, CardTypes.ARMOR, CardTypes.MOUNT, CardTypes.ITEMS));
    protected ComponentsSeries<ComponentPanelMenager<JComponent>> arrowMenager;
    protected ComponentPanelMenager<AbstractCustomButton> exitButton;

    protected DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;
    private int currentAttrSide = 0;

    @Override
    public AbstractCustomButton getCancelButton() {
        return cancelButton;
    }

    @Override
    public void setCancelButtonStatus(boolean status) {
        hasCancelPanel = status;
        showCancelPanel(hasCancelPanel);
    }

    protected void showCancelPanel(boolean status) {
        seriesPanel.getMainComponent(3).setVisible(hasCancelPanel && status);
    }

    protected void createCancelPanel() {
        seriesPanel.addMainComponent(1);
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        cancelButton = factory.createButton(CustomBundle.getString(canceltext), e -> seriesPanel.getCmp().setVisible(false));
        initializeCancelPanelObject(cancelButton, 0);
    }

    protected void initializeCancelPanelObject(AbstractCustomButton button, int index) {
        button.getCustomUI().setOffSet(12);
        button.getCustomUI().changeBorderStrategy(new DependantHeightBorderStrategy());
        seriesPanel.addMiddleComponent(button, 3, 10);
        seriesPanel.getMiddleComponent(3, index).addSpace(10, ComponentPanelMenager.Side.LEFT,
                ComponentPanelMenager.Side.RIGHT);
    }


    public Card(GuiFactory factory) {
        super(factory);
        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 14);

    }

    public void initialize() {
        createArrowComponentSeries();
        initSeriesPanel(arrowMenager, 2, 4);

        initializeWholeCard();
        createCancelPanel();
        setCancelButtonStatus(false);
        rightArrows.setSwitchableComponent(this);
    }


    protected void detailButtonMethod(DetailButtonsCard card, CardTypes type, int index) {

        var d = allCards.get(type).getDetailData();

        (type != CardTypes.ITEMS ? equipmentCard : textareaEquipmentCard).initializeCardData(allCards.get(type).getDetailData().get(allCards.get(type).getSideMaximumElementsNumber()
                - allCards.get(type).getMaximumElementNumber() + index), null);
        updateContent((type != CardTypes.ITEMS ? equipmentCard : textareaEquipmentCard));
        arrowMenager.getOption(1).changeContent(exitButton);

        showCancelPanel(false);

    }


    protected abstract DetailButtonsCard createDetailButtonCard(CardTypes type);


    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = createDetailButtonCard(type);
        but.initializeCard();
        for (int i = 0; i < but.getMaximumElementNumber(); i++) {
            int finalI = i;
            but.getDetailButton(i).addActionListener(e -> detailButtonMethod(but, type, finalI));
        }
        allCards.put(type, but);
    }


    protected abstract AttributesCard createAttributeCard();

    protected abstract AttributesCard createDetailItemCard();

    private void initializeWholeCard() {

        choserEqCard = new AddingButtonCard(factory);
        choserEqCard.initializeCard();


        amwGeneratorCard = new EntriesAttributesCard(factory);
        amwGeneratorCard.initializeCard();


        equipmentCard = createDetailItemCard();
        equipmentCard.initializeCard();
        textareaEquipmentCard = new TextAreaCard(factory);
        textareaEquipmentCard.initializeCard();
        var attrCard = createAttributeCard();
        attrCard.initializeCard();
        allCards.put(CardTypes.ATTRIBUTE, attrCard);
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.MOUNT, CardTypes.EFFECTS, CardTypes.WEAPONS,
                CardTypes.ITEMS)) {
            initializeDetailButtonsCardPart(type);
        }
        var map = new LinkedHashMap<CardTypes, ActionListener>();

        for (var key : cardSideIndexes) {
            if (key != CardTypes.OVERALL) {
                map.put(key, e -> switchSide(key));
            }
        }
        var overall = new OverallCard(factory, map);
        overall.initializeCard();
        allCards.put(CardTypes.OVERALL, overall);
        cardSideIndexes = new ArrayList<>();
        leftArrows.updateSwitchingButtons();
    }

    public void initializeCardData() {
        creatorData.put(CardTypes.ARMOR, new CardContentDataSet());
        creatorData.put(CardTypes.MOUNT, new CardContentDataSet());
        creatorData.put(CardTypes.WEAPONS, new CardContentDataSet());
    }

    public void uploadCreatorItemsData(CardContentDataSet weapon, CardContentDataSet mount, CardContentDataSet armor) {
        creatorData.put(CardTypes.ARMOR, armor);
        creatorData.put(CardTypes.MOUNT, mount);
        creatorData.put(CardTypes.WEAPONS, weapon);
        //jeszcze items albo i nie
    }

    public void uploadCreatorItemsData(CardContentDataSet data, CardTypes type) {
        creatorData.put(type, data);
        //jeszcze items albo i nie
    }


    public void setCreatorCard(boolean value, CardTypes type) {
        if (value) {
            amwGeneratorCard.initializeCardData(creatorData.get(type), null);
            updateContent(amwGeneratorCard);
        } else {
            updateContent(allCards.get(CardTypes.OVERALL));
            showCancelPanel(hasCancelPanel);
        }
    }

//    public void setEqChoserCard(boolean val, CardTypes types) {
//        if (val) {
//            //data init
//            updateContent(choserEqCard);
//            showCancelPanel(false);
//        } else {
//            showCancelPanel(hasCancelPanel);
//            updateContent();
//        }
//    }


    public void uploadNewData(LinkedHashMap<CardTypes, CardContentDataSet> newData, HashMap<CardTypes,
            ArrayList<CardContentDataSet>> detailData) {

        for (var type : newData.keySet()) {
            allCards.get(type).initializeCardData(newData.get(type), detailData.get(type));
        }
        cardSideIndexes = new ArrayList<>(newData.keySet());
        var map = new LinkedHashMap<CardTypes, ActionListener>();

        for (var key : cardSideIndexes) {
            if (key != CardTypes.OVERALL) {
                map.put(key, e -> switchSide(key));
            }
        }
        var overall = new OverallCard(factory, map);
        overall.initializeCard();
        allCards.put(CardTypes.OVERALL, overall);
        allCards.get(CardTypes.OVERALL).initializeCardData(newData.get(CardTypes.OVERALL),
                detailData.get(CardTypes.OVERALL));

        switchSide(cardSideIndexes.get(0));
        rightArrows.updateSwitchingButtons();
    }

    public void updateContent(AbstractCard newActiveCard) {
        activeCard.reset();
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
            case RIGHT -> status = currentAttrSide < cardSideIndexes.size() - 1;
        }
        return status;
    }


    protected void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    protected void methodOfRightDownPanelComponent() {
        arrowMenager.getOption(1).changeContent(rightArrows.getPanel());
        showCancelPanel(hasCancelPanel);
        updateContent();
    }

    protected void createArrowComponentSeries() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        exitButton = new ComponentPanelMenager<>(factory.createButton(CustomBundle.getString(exitText), null));
        exitButton.addSpace(5);
        exitButton.getComponent().addActionListener(e -> methodOfRightDownPanelComponent());
        arrowMenager = new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);
        leftArrows = new DoubleArrowPanel(factory, activeCard);
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
        equipmentCard.setUniformForm();
        amwGeneratorCard.setUniformForm();
        choserEqCard.setUniformForm();
    }

    public void setVisibility(boolean value) {
        setAspectVisible(activeCard.getContentMenager().getComponentsList(), value);
        setAspectVisible(new ArrayList<>(Arrays.asList(
                leftTitleComponent.getComponent(), rightTitleComponent.getComponent())), value);

    }


    protected void updateTitle() {

        leftTitleComponent.getComponent().setContent(activeCard.getFirstTitleContent());
        rightTitleComponent.getComponent().setContent(activeCard.getSecondTitleContent());
    }
}
