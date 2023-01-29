package gui.factories;

import controllers.utils.CreatureType;
import gui.bundle.CustomBundle;
import gui.card.fullCards.abstractCards.BaseCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.BasicCard;
import gui.card.fullCards.specificCards.EntriesCard;
import gui.card.fullCards.specificCards.GameCard;
import gui.card.fullCards.specificCards.GodCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.FullOnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleShowCard;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantWidthBorderStrategy;
import gui.data.TextData;
import gui.data.WarhammerData;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.factories.customFactories.buttonFactories.ButtonFactory;
import gui.factories.customFactories.buttonFactories.ClickedWarhammerBasicFactory;
import gui.factories.customFactories.buttonFactories.MenuButtonsFactory;
import gui.factories.customFactories.labelFactories.BasicLabelFactory;
import gui.factories.customFactories.labelFactories.ClickedLabelFactory;
import gui.factories.customFactories.labelFactories.LabelFactory;
import gui.factories.customFactories.labelFactories.MenuLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.menu.ICustomBackgorund;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.menuViews.MenuView;
import gui.views.menuViews.SelectingView;
import gui.views.objectViews.creationViews.ChoosingCreationGameView;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.itemsViews.FullSmallView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;
import gui.views.objectViews.itemsViews.ShowSmallView;
import gui.views.pickers.FullItemPicker;
import org.w3c.dom.Text;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static gui.data.TextData.createText;

public class WarHammerFactory extends IOverallFactory implements WarhammerData, TextData {
    private final ButtonFactory basicButtonFactory = new BasicButton();
    private final LabelFactory labelFactory = new BasicLabelFactory();
    private final LabelFactory clickedLabelFactory = new ClickedLabelFactory();
    private final ClickedWarhammerBasicFactory clickedFactoryButton = new ClickedWarhammerBasicFactory();
    private final MenuLabelFactory menuLabelFactory = new MenuLabelFactory(0.7, 0.2);
    private final MenuButtonsFactory menuButtonsFactory = new MenuButtonsFactory(0.6, 0.2);
    private TextFactory textFactory = new TextFieldFactory();

    private enum Mode {MENU, BASIC, CLICKED}

    public WarHammerFactory() {
        factory.setSpecificFont(fontPath, 14);
        factory.setButtonFactory(basicButtonFactory);
        factory.setBorderStrategy(new AverageBorderStartegy());
        factory.setLabelFactory(labelFactory);
        factory.setTextFactory(textFactory);
    }

    private void setFactoriesMode(Mode mode) {
        switch (mode) {
            case MENU -> {
                factory.setLabelFactory(menuLabelFactory);
                factory.setButtonFactory(menuButtonsFactory);
            }
            case BASIC -> {
                factory.setLabelFactory(labelFactory);
                factory.setButtonFactory(basicButtonFactory);
            }
            case CLICKED -> {
                factory.setLabelFactory(clickedLabelFactory);
                factory.setButtonFactory(clickedFactoryButton);
            }
        }
    }

    private void uploadBackgroundImage(ICustomBackgorund object, String path) {
        object.setBackgroundImage(path);
    }

    @Override
    public MenuView createMenuView() {
        factory.setBorderStrategy(new DependantHeightBorderStrategy());

        menuButtonsFactory.setPaths(smallSward1, smallSward1);
        menuLabelFactory.setPaths(smallSward2, WarhammerData.smallSward3);
        setFactoriesMode(Mode.MENU);
        var menu = new MenuView(factory, gameTitle);
        menu.setBorder(basicBorderColor, basicBorderSize);
        uploadBackgroundImage(menu, background1);
        return menu;
    }

    @Override
    public SelectingView createOverallItemPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(editPath, CustomBundle.getString(showText)),
                new AbstractMap.SimpleEntry<>(createPath,  CustomBundle.getString(createText)))));
    }

    @Override
    public SelectingView createOverallCreaturesPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(createPath,  CustomBundle.getString(createText)),
                new AbstractMap.SimpleEntry<>(viewPath, CustomBundle.getString(viewText)))));
    }

    private SelectingView createView(ArrayList<AbstractMap.SimpleEntry<String, String>> content) {
        factory.setBorderStrategy(new DependantWidthBorderStrategy());
        menuButtonsFactory.setPaths("", "");
        menuLabelFactory.setPaths("", "");
        setFactoriesMode(Mode.MENU);
        var menu = new SelectingView(factory, content);
        menu.setBorder(basicBorderColor, basicBorderSize);
        uploadBackgroundImage(menu, background1);
        factory.setBorderStrategy(new AverageBorderStartegy());
        return menu;
    }


    @Override
    public SelectingView createViewingItemsPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(horsePath, CustomBundle.getString(mountText)),
                new AbstractMap.SimpleEntry<>(armorPath, CustomBundle.getString(armorText)),
                new AbstractMap.SimpleEntry<>(weaponPath, CustomBundle.getString(weaponText)),
                new AbstractMap.SimpleEntry<>(trolleyPath, CustomBundle.getString(itemText)))));
    }

    @Override
    public SelectingView createCreaturesPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(monsterPath, CustomBundle.getString(monsterText)),
                new AbstractMap.SimpleEntry<>(playerImagePath, CustomBundle.getString(playerText)),
                new AbstractMap.SimpleEntry<>(npcImage, CustomBundle.getString(npcText)))));
    }

    @Override
    public MainPanelGame createMainPanelGame() {
        setFactoriesMode(Mode.BASIC);
        factory.setButtonFactory(basicButtonFactory);
        factory.setLabelFactory(labelFactory);
        var mainPanel = new MainPanelGame(this);
        var map = new HashMap<FullItemPicker.LabelType, String>();
        map.put(FullItemPicker.LabelType.WEAPON, weaponPath);
        map.put(FullItemPicker.LabelType.MOUNT, horsePath);
        map.put(FullItemPicker.LabelType.ARMOR, armorPath);
        mainPanel.initializePicker(map);
        mainPanel.getGamePanel().setBorder(basicBorderColor, basicBorderSize);
        mainPanel.getActivityOptionsPanel().initializeButtonsData(new ArrayList<>(Arrays.asList(targetOpt,
                defenseStandOpt, blockOption)));
        mainPanel.getActivityOptionsPanel().initializeLabelsData(new ArrayList<>(Arrays.asList("1", "2", "1")));

        mainPanel.getGamePanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(moveOption,
                cardOption, normalAttackOpt, carefullattackOpt,
                fastAttactOpt)));
        mainPanel.getGamePanel().initializeOptionsPanelLabelData(new ArrayList<>(Arrays.asList("1", "0", "1", "2", "2"
        )));
        mainPanel.getGamePanel().changeActiveOptionsPanel();
        mainPanel.getGamePanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(tapImage,
                cardOption)));
        mainPanel.getGamePanel().changeActiveOptionsPanel();
        mainPanel.getGamePanel().setAttackArmorPathContent(armorPath, knivesOpt);
        return mainPanel;
    }

    @Override
    public ChoosingCreationGameView createchoosingCreationGameView() {
        setFactoriesMode(Mode.BASIC);
        var panel = new ChoosingCreationGameView(this);
        panel.initialize();
        return panel;
    }

    public CreatorPanel createCreatorPanel() {
        setFactoriesMode(Mode.BASIC);
        var panel = new CreatorPanel(this, 10);
        panel.initialize();
        panel.setBorder(basicBorderColor, basicBorderSize);
        panel.setBasePath(TextData.plusImage);
        return panel;
    }

    @Override
    public CreatorGameView createCreatorGameView() {
        setFactoriesMode(Mode.BASIC);
        var creator = new CreatorGameView(this, 10);
        creator.getCreatorPanel().setBasePath(TextData.plusImage);
        creator.getCreatorPanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(monsterPath,
                playerImagePath, npcImage)));
        return creator;
    }

    public EntriesCard createEntriesCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new EntriesCard(factory);
        initCard(card);
        return card;
    }

    public BasicCard createBasicCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new BasicCard(factory);
        initCard(card);
        return card;
    }
    private void initCard(Card card){
        initCard((BaseCard) card);
        card.setCancelButtonStatus(true);
    }

    @Override
    public GameCard createGameCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new GameCard(factory);
        initCard(card);
        return card;
    }

    public EntriesCard createCreatorCard(Card.CardTypes type) {
        setFactoriesMode(Mode.CLICKED);
        var card = new EntriesCard(factory);
        initCard(card);
        card.initializeCardData();
        card.setCreatorCard(true, type);
        return card;
    }

    @Override
    public ShowApplyCreatureView createCreatorApplyingCharacterView(CreatureType type) {
        setFactoriesMode(Mode.CLICKED);
        var obj = new ShowApplyCreatureView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        switch (type) {
            case NPC -> obj.uploadMainImageData(npcImage);
            case MONSTER -> obj.uploadMainImageData(monsterPath);
            case PLAYER_CHARACTER -> obj.uploadMainImageData(playerImagePath);
        }
        return obj;
    }

    @Override
    public FullOnlyVisibleCard createSmallFullCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new FullOnlyVisibleCard(factory);
        factory.setBorderStrategy(new AverageBorderStartegy());
        initCard(card);
        card.setBorder(basicBorderColor, basicBorderSize * 2);
        return card;
    }

    @Override
    public OnlyVisibleShowCard createSmallOnlyShowCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new OnlyVisibleShowCard(factory);
        factory.setBorderStrategy(new AverageBorderStartegy());
        initCard(card);
        card.setBorder(basicBorderColor, basicBorderSize * 2);
        return card;
    }

    public FullSmallView createAllMonstersView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(monsterPath);
        return card;
    }

    public FullSmallView createAllCharactersView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(playerImagePath);
        return card;
    }

    public FullSmallView createAllNPCView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(npcImage);
        return card;
    }

    private FullSmallView createAllEditableItemsView() {
        setFactoriesMode(Mode.CLICKED);
        var obj = new FullSmallView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        return obj;
    }

    public FullSmallView createAllWeaponsItemsView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(weaponPath);
        return card;
    }

    public FullSmallView createAllMountsItemsView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(horsePath);
        return card;
    }

    public ShowSmallView createAllItemsItemsView() {
        setFactoriesMode(Mode.CLICKED);
        var obj = new ShowSmallView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        obj.uploadMainImageData(trolleyPath);
        return obj;
    }

    public FullSmallView createAllArmorsItemsView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(armorPath);
        return card;
    }

    @Override
    public GodCard createGodCard() {
        var card = new GodCard(factory);
        initCard(card);
        return card;

    }


    private void initCard(BaseCard card){
        card.setBorder(basicBorderColor, basicBorderSize);
        card.initialize();
        card.setBackgroundImage(cardBackground);
        card.setUniformFont();
    }
}
