package gui.card.contentCards.detailCards;

import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.CustomButton;
import gui.customComponents.IContentCustomUICmp;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.CustomMenuMenager;
import gui.menu.DefaultCustomMenuMenager;

import javax.swing.*;
import java.util.ArrayList;

public class AddingItemButtonCard extends NormalDetailButtonsCard {
    private DefaultCustomMenuMenager secondCustomMenager = new CustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL, ComponentsSeries.ComponentsDimension.HORIZONTAL);

//    private ComponentsSeries<ComponentPanelMenager<JComponent>> plusButtonPanel;
    private AbstractCustomButton button;
//    private ComponentsSeries usedCmp = null;

    public AbstractCustomButton getPlusButton() {
        return button;
    }

    public AddingItemButtonCard(GuiFactory factory) {
        super(factory);
    }

    private AbstractCustomButton createCustomButton() {
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        var button = factory.createButton("add new Item", null);
        return button;
    }

//    @Override
//    protected void updateContent() {
//        super.updateContent();
////        for (int i = 0; i < maximumElementNumber; i++) {
//////                for (int j = 0; j < 2; j++) {
//////                    getContentList().get(2 * i + j).setContent(Card.EMPTY_DATA_CONTENT);
//////                }
////            if (labelList.get(i).getContent() == Card.EMPTY_DATA_CONTENT &&
////                    getContentList().get(i).getContent() == Card.EMPTY_DATA_CONTENT &&
////                    detailList.get(i).getContent() == Card.EMPTY_DATA_CONTENT) {
////                usedCmp = menager.getMainComponent(1).getComponent();
////
////                menager.getMainComponent(1).changeContent(plusButtonPanel);
////                break;
////            }
////
////            getContentList().get(i).setContent(Card.EMPTY_DATA_CONTENT);
////
////            detailList.get(i).setContent(Card.EMPTY_DATA_CONTENT);
////        }
//    }

    @Override
    public DefaultCustomMenuMenager<JComponent> getContentMenager() {
        return secondCustomMenager;
    }

    @Override
    protected void initializeContent() {
        super.initializeContent();
        secondCustomMenager.addMainComponent(8);
        secondCustomMenager.addMainComponent(2);
        button = createCustomButton();
        var panel = new ComponentPanelMenager<JComponent>(button);
        panel.addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.LEFT);
        panel.addSpace(1, ComponentPanelMenager.Side.TOP, ComponentPanelMenager.Side.BOTTOM);

        secondCustomMenager.addMiddleComponent(super.getContentMenager().getCmp(), 0,11 );
        secondCustomMenager.addMiddleComponent(panel, 1,11 );
//        plusButtonPanel = new ComponentsSeries<>(ComponentsSeries.Componens
    }
}
