package gui.card.fullCards.specificCards;

import gui.card.CardContentDataSet;
import gui.card.DoubleArrowPanel;
import gui.card.contentCards.attributesCards.AttributesCard;
import gui.card.contentCards.attributesCards.EntriesAttributesCard;
import gui.card.contentCards.attributesCards.LabelAttributeCard;
import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.AddingItemButtonCard;
import gui.card.contentCards.detailCards.DetailButtonsCard;
import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.customComponents.customTextComponents.CustomTextComponent;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.utils.FileCopyManager;
import gui.utils.StringAdapter;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class EntriesCard extends Card {
    public enum EntryType {SPINNER, ENTRY}
    private boolean isImageSet = false;
    private AddingButtonCard choserEqCard2 = null;
    private ChoserCard choserCard;
    protected ComponentPanelMenager<AbstractCustomButton> addButton;
    private JComponent helpPanelVariable;
    private AbstractCustomButton saveButton;
    protected ComponentPanelMenager<CustomTextComponent> rightEntryTitleComponent;
    protected ComponentPanelMenager<AbstractCustomButton> leftButtonyTitleComponent;

    public EntriesCard(GuiFactory factory) {
        super(factory);
    }

    public HashMap<CardTypes, CardContentDataSet> generateContentData() {
        var newMapa = new HashMap<CardTypes, CardContentDataSet>();
        newMapa.put(CardTypes.ATTRIBUTE, allCards.get(CardTypes.ATTRIBUTE).getData());
        for (var type : allCards.keySet()) {
            newMapa.put(type, allCards.get(type).getData());
        }
        return newMapa;
    }

    @Override
    public void setBackgroundImage(String path) {
        super.setBackgroundImage(path);
        choserCard.setBackgroundImage(path);
    }

    public boolean isImageSet() {
        return isImageSet;
    }

    public HashMap<CardTypes, CardContentDataSet> getIndexesData() {
        var newMapa = new HashMap<CardTypes, CardContentDataSet>();
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.WEAPONS, CardTypes.MOUNT, CardTypes.ITEMS)) {
            newMapa.put(type, choserCard.getGameSelectedCard(type).getOnlyAddedIndexesData());
        }//niepotrzebn ale kto wie...
        return newMapa;

    }

    public HashMap<CardTypes, ArrayList<Integer>> generateIndexesNumberData() {
        var newMapa = new HashMap<CardTypes, ArrayList<Integer>>();
        for (var type : Arrays.asList(CardTypes.ARMOR, CardTypes.WEAPONS, CardTypes.MOUNT, CardTypes.ITEMS)) {
            newMapa.put(type, choserCard.getGameSelectedCard(type).getAddedIndexes());
        }
        return newMapa;
    }


    @Override
    protected DetailButtonsCard createDetailButtonCard(CardTypes type) {
        var card = new AddingItemButtonCard(factory);

        card.getPlusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choserCard.switchSide(type);
                seriesPanel.getCmp().changeContent(choserCard.getPanel());
            }
        });
        return card;
    }

    public void setCurrentCardType(CardTypes type) {
        choserCard.setCurrentType(type);
    }

    @Override
    public void initialize() {
        super.initialize();
        choserCard = new ChoserCard(factory);
        choserCard.initialize();
        helpPanelVariable = seriesPanel.getCmp().getComponent();
        choserCard.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seriesPanel.getCmp().changeContent(helpPanelVariable);
                allCards.get(choserCard.getCurrentCardType()).initializeCardData(choserCard.getCurrentData(),
                        choserCard.getCurrentDetailData());
                updateContent();
            }
        });
    }


    @Override
    public void uploadNewData(LinkedHashMap<CardTypes, CardContentDataSet> newData, HashMap<CardTypes,
            ArrayList<CardContentDataSet>> detailData) {
        super.uploadNewData(newData, detailData);
        uploadNewChoserCardData(newData, detailData);
    }

    public void uploadNewChoserCardData(LinkedHashMap<CardTypes, CardContentDataSet> newData, HashMap<CardTypes,
            ArrayList<CardContentDataSet>> detailData) {
        choserCard.uploadNewData(newData, detailData);
        for (var key : detailData.keySet()) {
            choserCard.setCurrentType(key);
            var array = new ArrayList<Integer>();

            for (var data : detailData.get(key)) {
                for (var data2 : allCards.get(key).getDetailData()) {
                    if (data.equals(data2) && !array.contains(detailData.get(key).indexOf(data))) {
                        array.add(detailData.get(key).indexOf(data));
                    }
                }
            }
            choserCard.getGameSelectedCard(key).setAddedIndexes(array);
            choserCard.getGameSelectedCard(key).reset();
            allCards.get(key).initializeCardData(choserCard.getCurrentData(),
                    choserCard.getCurrentDetailData());
        }
        updateContent();
        choserCard.updateContent();
    }

    @Override
    protected AttributesCard createAttributeCard() {
        return new EntriesAttributesCard(factory);
    }

    @Override
    protected AttributesCard createDetailItemCard() {
        return new LabelAttributeCard(factory);
    }


    @Override
    protected void updateTitle() {
        super.updateTitle();
        if (activeCard == allCards.get(CardTypes.OVERALL) || activeCard == amwGeneratorCard) {
            setTitleOptionsVisible(Side.RIGHT, 1);
            setTitleOptionsVisible(Side.LEFT, 1);
        } else {
            setTitleOptionsVisible(Side.RIGHT, 0);
            setTitleOptionsVisible(Side.LEFT, 0);
        }
    }

    @Override
    public void initializeTitle() {
        super.initializeTitle();
        rightEntryTitleComponent = new ComponentPanelMenager<>(factory.createTextField());
        rightEntryTitleComponent.getComponent().getTextComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (activeCard == amwGeneratorCard) {
                    amwGeneratorCard.getData().titleContent = rightEntryTitleComponent.getComponent().getContent();
                } else {
                    allCards.get(CardTypes.OVERALL).getData().titleContent =
                            rightEntryTitleComponent.getComponent().getContent();
                }
            }
        });
        initializeRightTitleComponent(rightEntryTitleComponent, 1);
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        var but = factory.createButton(StringAdapter.getRelativePath("image.png"), null);
        but.getCustomUI().setOffSet(0);
        leftButtonyTitleComponent = new ComponentPanelMenager<>(but);
        leftButtonyTitleComponent.getComponent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var chooser = new JFileChooser();
                int answer = chooser.showOpenDialog(new JFrame());
                if (answer == JFileChooser.APPROVE_OPTION) {
                    isImageSet = true;
                    leftButtonyTitleComponent.getComponent().setContent(String.valueOf(chooser.getSelectedFile().getAbsolutePath()));
                    activeCard.getData().titlePath = StringAdapter.getRelativePath(FileCopyManager.getLastFileName());
                    FileCopyManager.copyFile(String.valueOf(chooser.getSelectedFile().getPath()));
                }
            }
        });
        initializeLeftTitleComponent(leftButtonyTitleComponent, 1);
    }

    public AbstractCustomButton getSaveButton() {
        return saveButton;
    }

    @Override
    protected void createCancelPanel() {
        super.createCancelPanel();
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        saveButton = factory.createButton("SAVE", null);
        initializeCancelPanelObject(saveButton, 1);
    }

    public CardContentDataSet getCurrectCreatorItemData() {
        amwGeneratorCard.getData().titlePath = leftButtonyTitleComponent.getComponent().getContent();
        amwGeneratorCard.getData().titleContent = rightEntryTitleComponent.getComponent().getContent();
        return amwGeneratorCard.generateContentData();
    }


    public void setTitleIncorrect(Side side, int periodTime) {
        switchSide(CardTypes.OVERALL);
        leftArrows.updateSwitchingButtons();
        if (side == Side.RIGHT) {
            var cmp = rightEntryTitleComponent.getComponent();
            var previousBG = cmp.getBackground();
            cmp.setBackground(new Color(0x570606));
            var timer = new Timer(periodTime, e -> cmp.setBackground(previousBG));
            timer.setRepeats(false);
            timer.start();
        }
        if (side == Side.LEFT) {
            var cmp = leftButtonyTitleComponent.getComponent();
            var cnt = cmp.getContent();
            cmp.setContent(StringAdapter.getRelativePath("disimage.png"));
            var timer = new Timer(periodTime, e -> {
                cmp.setContent(cnt);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void setEntriesIncorrect(ArrayList<Integer> values, int periodTime) {
        if (values.size() > 0) {
            if (!(activeCard == amwGeneratorCard)) {
                switchSide(CardTypes.ATTRIBUTE);
            }
            activeCard.reset();
            for (int j = 0; j < values.get(0) / activeCard.getMaximumElementNumber(); j++) {
                activeCard.switchSide(DoubleArrowPanel.Side.RIGHT);
                leftArrows.updateSwitchingButtons();
            }
        }

        for (int i = 0; i < values.size(); i++) {
            if (!(activeCard == amwGeneratorCard)) {
                ((EntriesAttributesCard) this.allCards.get(CardTypes.ATTRIBUTE)).setEntryIncorrect(values.get(i),
                        periodTime);
            } else {
                amwGeneratorCard.setEntryIncorrect(values.get(i), periodTime);
            }
        }

    }


}
