package gui.card.fullCards.specificCards;

import gui.card.DoubleArrowPanel;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.contentCards.detailCards.NormalDetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.CustomBooleanButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;

import java.util.ArrayList;

public class ChoserCard extends Card {
    private ComponentPanelMenager<AbstractCustomButton>  button;
    private ArrayList<AddingButtonCard> cards = new ArrayList<>();


    public ChoserCard(GuiFactory factory) {
        super(factory);
    }

    @Override
    public void initialize() {
        super.initialize();
//        switchTo(CardTypes.ARMOR);
    }

    public void switchTo(CardTypes type){
        switchSide(type);
    }

    @Override
    protected DetailButtonsCard createDetailButtonCard() {
        return new NormalDetailButtonsCard(factory);
    }




    @Override
    protected void initializeDetailButtonsCardPart(CardTypes type) {
//        super.initializeDetailButtonsCardPart(type);
        var but = new AddingButtonCard(factory);
        but.initializeCard();
        allCards.put(type, but);
        cards.add(but);
        but.getDetailButton(0).addActionListener(e->detailButtonMethod(but));

    }

    public AddingButtonCard getGameSelectedCard(int index) {
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
        button = new ComponentPanelMenager<>(factory.createButton("ADD", null));
        button.addSpace(5);
        arrowMenager.getOption(1).changeContent(new ComponentPanelMenager<>(button));
    }
    @Override
    protected   void methodOfRightDownPanelComponent() {
        super.methodOfRightDownPanelComponent();
        arrowMenager.getOption(1).changeContent(button);//to fix
    }

}
