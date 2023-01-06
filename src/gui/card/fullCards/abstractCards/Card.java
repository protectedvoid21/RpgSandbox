package gui.card.fullCards.abstractCards;

import gui.card.*;
import gui.card.contentCards.AbstractCard;
import gui.card.contentCards.OverallCard;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.EmptyCard;
import gui.card.contentCards.attributesCards.EntriesAttributesCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.customComponents.*;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class Card extends BaseCard implements SwitchableComponent, ICancelCard {
    static final public String EMPTY_DATA_CONTENT = "";

    private boolean hasCancelButton = false;
    private AbstractCustomButton cancelButton = null;

    protected AbstractCard activeCard = new EmptyCard();
    protected Map<CardTypes, AbstractCard> allCards = new HashMap<>();
    private AttributesCard equipmentCard;

    private AttributesCard amwGeneratorCard;

    private AttributesCard choserEqCard = null;


    //    private AttributesCard lefteqChoserPanel;
//    private
    private HashMap<CreatorTypes, CardContentDataSet> creatorData = new HashMap<>();

    public enum CreatorTypes {ARMOR, WEAPONS, MOUNT}
    public enum DetailTypes {ARMOR, WEAPONS, MOUNT, ITEMS}
    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, OVERALL, MOUNT, ITEMS}

    private HashMap<DetailTypes, ArrayList<CardContentDataSet>> detailTypesData = new HashMap<>();

    protected static ArrayList<CardTypes> cardSideIndexes = new ArrayList<>(Arrays.asList(CardTypes.OVERALL,
            CardTypes.ATTRIBUTE,
            CardTypes.WEAPONS, CardTypes.EFFECTS, CardTypes.ARMOR, CardTypes.MOUNT, CardTypes.ITEMS));
    protected ComponentsSeries<ComponentPanelMenager<JComponent>> arrowMenager;
    private ComponentPanelMenager<AbstractCustomButton> exitButton;
    private ComponentPanelMenager<AbstractCustomButton> exitCreatorCard;
    protected DoubleArrowPanel leftArrows;
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
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
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

    public void uploadDetailData(HashMap<DetailTypes, ArrayList<CardContentDataSet>> detailData){
        detailTypesData = detailData;
    }

    protected void detailButtonMethod(DetailButtonsCard card, CardTypes type, int index) {
//        equipmentCard.initializeCardData(card.getData().eqData.get(0));
        equipmentCard.initializeCardData(detailTypesData.get(type).get(activeCard.getSideMaximumElementsNumber()- activeCard.getMaximumElementNumber()+index));
        updateContent(equipmentCard);
        arrowMenager.getOption(1).changeContent(exitButton);//yyyyto fix
        showCancelButton(false);
    }


    protected abstract DetailButtonsCard createDetailButtonCard();


    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = createDetailButtonCard();
        but.initializeCard();
        for (int i = 0; i<but.getMaximumElementNumber(); i++){
            but.getDetailButton(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                eqaCard = activeCard;
                    detailButtonMethod(but, type);
                }
            });
        }
//        but.getDetailButton(0).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                eqaCard = activeCard;
//                detailButtonMethod(but);
//            }
//        });
        allCards.put(type, but);//tutaj trzeba buttonom nadac komendy, CardContent bedzie mogl zawierac CardContentn
        // np z armorami
    }


    protected abstract AttributesCard createAttributeCard();

    protected abstract AttributesCard createDetailItemCard();

    private void initializeWholeCard() {
        amwGeneratorCard = new EntriesAttributesCard(factory);
        amwGeneratorCard.initializeCard();


        equipmentCard = createDetailItemCard();
        equipmentCard.initializeCard();
        var attrCard = createAttributeCard();
        attrCard.initializeCard();
        allCards.put(CardTypes.ATTRIBUTE, attrCard);
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.MOUNT, CardTypes.EFFECTS, CardTypes.WEAPONS,
                CardTypes.ITEMS)) {
            initializeDetailButtonsCardPart(type);
        }
        var map = new ArrayList<ActionListener>();

        for (var key : cardSideIndexes.subList(1, cardSideIndexes.size())) {
            map.add(e -> switchSide(key));
        }
        var overall = new OverallCard(factory, map);
        overall.initializeCard();
        allCards.put(CardTypes.OVERALL, overall);
    }

    public void uploadCreatorItemsData(CardContentDataSet weapon, CardContentDataSet mount, CardContentDataSet armor) {
        creatorData.put(CreatorTypes.ARMOR, armor);
        creatorData.put(CreatorTypes.MOUNT, mount);
        creatorData.put(CreatorTypes.WEAPONS, weapon);
        //jeszcze items albo i nie

    }

    public void setCreatorCard(boolean value, CreatorTypes type) {

        if (value) {
            amwGeneratorCard.initializeCardData(creatorData.get(type));
            updateContent(amwGeneratorCard);
            arrowMenager.getOption(1).changeContent(exitCreatorCard);//yyyyto fix
//            for (var action :exitButton.getComponent().getActionListeners() ){
//                exitButton.getComponent().removeActionListener(action);
//            }


            showCancelButton(false);
        } else {
            updateContent(allCards.get(CardTypes.OVERALL));
            arrowMenager.getOption(1).changeContent(rightArrows.getPanel());
            showCancelButton(hasCancelButton);
        }
    }

    public void setEqChoserCard(boolean val, CreatorTypes types) {
        if (val) {
            //data init
            updateContent(choserEqCard);
            showCancelButton(false);
        } else {
            showCancelButton(hasCancelButton);
            updateContent();
        }
    }


    public void uploadNewData(HashMap<CardTypes, CardContentDataSet> newData) {
        for (var type : newData.keySet()) {
            allCards.get(type).initializeCardData(newData.get(type));
        }
        var a = new ArrayList<CardTypes>();
        for (var key : newData.keySet()) {
            a.add(key);
        }
        cardSideIndexes = a;

        switchSide(cardSideIndexes.get(0));
    }

//    public void generateData()

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
            case RIGHT -> status = currentAttrSide < cardSideIndexes.size() - 1;
        }
        return status;
    }


    protected void initSeriesPanel(JComponent content, int mainIndex, int weight) {
        seriesPanel.addMainComponent(weight);
        seriesPanel.addMiddleComponent(content, mainIndex, 10);
    }

    protected void methodOfRightDownPanelComponent() {
        arrowMenager.getOption(1).changeContent(rightArrows.getPanel());//to fix
        showCancelButton(hasCancelButton);
        updateContent();
    }

    protected void createArrowComponentSeries() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        exitButton = new ComponentPanelMenager<>(factory.createButton("exit", null));
        exitButton.addSpace(5);

        exitCreatorCard = new ComponentPanelMenager<>(factory.createButton("exit2", null));
        exitCreatorCard.addSpace(5);

        exitButton.getComponent().addActionListener(e -> methodOfRightDownPanelComponent());

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
        equipmentCard.setUniformForm();
        amwGeneratorCard.setUniformForm();
    }

    public void setVisibility(boolean value) {
        setAspectVisible(activeCard.getContentMenager().getComponentsList(), value);
//        setAspectVisible(new ArrayList<>(titleSeries.getComponentsList().stream().map(cmp -> cmp.getComponent())
//        .toList()), value);
        setAspectVisible(new ArrayList<>(Arrays.asList(rightEntryTitleComponent.getComponent(),
                leftTitleComponent.getComponent(), rightTitleComponent.getComponent())), value);

    }


    protected void updateTitle() {//zmienia sie
//        leftTitleComponent.setVisible(false);
//        leftTitleComponent.setVisible(true);
//        rightTitleComponent.setVisible(false);
//        rightTitleComponent.setVisible(true);
        leftTitleComponent.getComponent().setContent(activeCard.getFirstTitleContent());
        rightTitleComponent.getComponent().setContent(activeCard.getSecondTitleContent());
//        if (activeCard== allCards.get(CardTypes.OVERALL)){
//            titleSeries.getOption(1).changeContent(getRightTitleComponent().getComponent());
//            getRightTitleComponent().getComponent().setContent(activeCard.getSecondTitleContent());
//        }else{
//            titleSeries.getOption(1).changeContent(rightTitleComponent.getComponent());
//            rightTitleComponent.getComponent().setContent(activeCard.getSecondTitleContent());
//        }

//        getRightTitleComponent().getComponent().setContent(activeCard.getSecondTitleContent());
    }
}
