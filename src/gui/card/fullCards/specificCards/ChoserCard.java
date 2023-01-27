package gui.card.fullCards.specificCards;

import gui.card.CardContentDataSet;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.contentCards.detailCards.NormalDetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoserCard extends Card {
    private ComponentPanelMenager<AbstractCustomButton> button;
    private final HashMap<CardTypes, AddingButtonCard> cards = new HashMap<>();
    private CardTypes currentCardType;
    public ChoserCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    public void initialize() {
        super.initialize();
        seriesPanel.getCmp().removeBorderData();
        setUniformFont();
    }

    @Override
    public void setUniformFont() {
        super.setUniformFont();
    }

    public void setCurrentType(CardTypes type) {
        currentCardType = type;
        cards.get(currentCardType).setUniformForm();
    }

    public CardTypes getCurrentCardType() {
        return currentCardType;
    }


    @Override
    public void switchSide(CardTypes cardType) {
        super.switchSide(cardType);
        currentCardType = cardType;
    }

    @Override
    protected DetailButtonsCard createDetailButtonCard(CardTypes type) {
        return new NormalDetailButtonsCard(factory);
    }


    public AbstractCustomButton getAddButton() {
        return button.getComponent();
    }
    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = new AddingButtonCard(factory);
        var array =new ArrayList<>();
        but.initializeCard();
        allCards.put(type, but);
        cards.put(type, but);
        for (int i = 0; i < but.getMaximumElementNumber(); i++) {
            int finalI = i;
            but.getDetailButton(i).addActionListener(e -> detailButtonMethod(but, type, finalI));
        }

    }

    public AddingButtonCard getGameSelectedCard(CardTypes index) {
        return cards.get(index);
    }

    @Override
    protected AttributesCard createAttributeCard() {
        return new LabelAttributeCard(factory);
    }

    @Override
    protected AttributesCard createDetailItemCard() {
        return createAttributeCard();
    }

    @Override
    protected void createArrowComponentSeries() {
        super.createArrowComponentSeries();
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        button = new ComponentPanelMenager<>(factory.createButton(addText, null));
        button.addSpace(5);
        arrowMenager.getOption(1).changeContent(new ComponentPanelMenager<>(button));
    }

    public ArrayList<CardContentDataSet> getCurrentDetailData() {
        return cards.get(currentCardType).getDetailOnlyAddedIndexesData();
    }

    public CardContentDataSet getCurrentData() {
        return cards.get(currentCardType).getOnlyAddedIndexesData();
    }

    @Override
    protected void methodOfRightDownPanelComponent() {
        super.methodOfRightDownPanelComponent();
        arrowMenager.getOption(1).changeContent(button);
    }


}
