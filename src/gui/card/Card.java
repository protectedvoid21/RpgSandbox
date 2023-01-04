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

public class Card extends BaseCard implements SwitchableComponent, ICancelCard {
    static final public String EMPTY_DATA_CONTENT = "";

    private boolean hasCancelButton = false;
    private AbstractCustomButton cancelButton = null;

    private AbstractCard activeCard = new EmptyCard();


    protected Map<CardTypes, AbstractCard> allCards = new HashMap<>();
    private AttributesCard equipmentCard = new AttributesCard(factory);

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


    public enum CardTypes {ATTRIBUTE, ARMOR, WEAPONS, EFFECTS, OVERALL, MOUNT}

    protected static ArrayList<CardTypes> cardSideIndexes = new ArrayList<>(Arrays.asList(CardTypes.OVERALL,
            CardTypes.ATTRIBUTE,
            CardTypes.WEAPONS, CardTypes.EFFECTS, CardTypes.ARMOR, CardTypes.MOUNT));

//    private ComponentsSeries<ComponentPanelMenager<AbstractCustomLabel>> titleSeries =
//            new ComponentsSeries<>(ComponentsSeries.ComponentsDimension.HORIZONTAL);

    private ComponentsSeries<ComponentPanelMenager<JComponent>> arrowMenager;
    private ComponentPanelMenager<AbstractCustomButton> exitButton;
    private DoubleArrowPanel leftArrows;
    private DoubleArrowPanel rightArrows;

    //    protected DefaultCustomMenuMenager seriesPanel;
//    protected GuiFactory factory;
    private int currentAttrSide = 0;

    public Card(GuiFactory factory) {
        super(factory);

//        seriesPanel = new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
//                ComponentsSeries.ComponentsDimension.HORIZONTAL);
//        initSeriesPanel(titleSeries, 0, 6);
//        initSeriesPanel(ComponentPanelMenager.createEmptyInstance(), 1, 14);
        createArrowComponentSeries();
        initSeriesPanel(arrowMenager, 2, 4);

        initializeWholeCard();
        createCancelButton();
        setCancelButtonStatus(false);
//        initializeTitle();
        rightArrows.setSwitchableComponent(this);
//        seriesPanel.getCmp().setBorderData(Color.RED, new AverageBorderStartegy(), 8);
    }


    protected void initializeDetailButtonsCardPart(CardTypes type) {
        var but = new DetailButtonsCard(factory);
        but.getDetailButton(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                eqaCard = activeCard;
                equipmentCard.initializeCardData(but.getData().eqData.get(0));
                updateContent(equipmentCard);
                arrowMenager.getOption(1).changeContent(exitButton);//yyyyto fix
                showCancelButton(false);
            }
        });
        allCards.put(type, but);//tutaj trzeba buttonom nadac komendy, CardContent bedzie mogl zawierac CardContentn
        // np z armorami
    }

    public void initializeWholeCard() {
        allCards.put(CardTypes.ATTRIBUTE, new AttributesCard(factory));
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
        if (newActiveCard != equipmentCard) {
            activeCard.reset();
        }
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


//    public void setBackgroundImage(String path) throws IOException {
//        seriesPanel.getCmp().setBackgroundImage(path);
//    }
//
//    public void setBackgroundColor(Color color) {
//        seriesPanel.setBackground(color);
//    }
//
//    public JPanel getPanel() {
//        return seriesPanel.getCmp();
//    }

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

//    public static <T extends JComponent & IContentCustomUICmp> void setAspectVisible(ArrayList<T> container,
//                                                                                     boolean value) {
//        for (var cmp : container) {
//            cmp.setVisible(cmp.getContent().isEmpty() ? false : value);
//        }
//    }


//    public void initializeTitle() {//zmienia sie
//        factory.setLabelType(GuiFactory.LabelType.ICON);
//        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(EMPTY_DATA_CONTENT)), 30);
//        titleSeries.getOption(0).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.TOP);
//        titleSeries.getOption(0).addSpace(1, ComponentPanelMenager.Side.RIGHT);
//        titleSeries.getOption(0).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
//
//        factory.setLabelType(GuiFactory.LabelType.NORMAL);
//        titleSeries.addOption(new ComponentPanelMenager<>(factory.createLabel(EMPTY_DATA_CONTENT)), 30);
//        titleSeries.getOption(1).addSpace(6, ComponentPanelMenager.Side.RIGHT, ComponentPanelMenager.Side.TOP);
//        titleSeries.getOption(1).addSpace(1, ComponentPanelMenager.Side.LEFT);
//        titleSeries.getOption(1).addSpace(2, ComponentPanelMenager.Side.BOTTOM);
//
//    }


    protected void updateTitle() {//zmienia sie
        titleSeries.getOption(0).getComponent().setContent(activeCard.getFirstTitleContent());
        titleSeries.getOption(1).getComponent().setContent(activeCard.getSecondTitleContent());
    }
}
