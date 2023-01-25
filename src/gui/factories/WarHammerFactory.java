package gui.factories;

import game.generals.Vector2;
import gui.card.CardContentDataSet;
import gui.card.fullCards.specificCards.onlyVisibleCards.FullOnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleShowCard;
import gui.factories.customFactories.buttonFactories.*;
import gui.factories.customFactories.labelFactories.*;
import gui.factories.customFactories.textComponentFactory.TextFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.utils.StringAdapter;
import gui.views.TitleView;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.CardCancelView;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.creationViews.ChoosingCreationGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;
import gui.views.menuViews.SelectingView;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantWidthBorderStrategy;
import gui.menu.ICustomBackgorund;
import gui.views.menuViews.MenuView;
import gui.views.objectViews.itemsViews.FullSmallView;
import gui.views.objectViews.itemsViews.ShowSmallView;

import java.util.*;

public class WarHammerFactory extends IOverallFactory implements WarhammerData {
    private ButtonFactory basicButtonFactory = new BasicButton();
    private LabelFactory labelFactory = new BasicLabelFactory();
    private LabelFactory clickedLabelFactory = new ClickedLabelFactory();
    private ClickedWarhammerBasicFactory clickedFactoryButton = new ClickedWarhammerBasicFactory();
    private MenuLabelFactory menuLabelFactory = new MenuLabelFactory(0.7, 0.2);
    private MenuButtonsFactory menuButtonsFactory = new MenuButtonsFactory(0.6, 0.2);
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

        menuButtonsFactory.setPaths(StringAdapter.getRelativePath("swo.png"), StringAdapter.getRelativePath("swo.png"));
        menuLabelFactory.setPaths(StringAdapter.getRelativePath("leftsword.png"), StringAdapter.getRelativePath(
                "rightsword.png"));
        setFactoriesMode(Mode.MENU);
        var menu = new MenuView(factory);
        menu.setBorder(basicBorderColor, basicBorderSize);
        uploadBackgroundImage(menu, background1);
        return menu;
    }

    @Override
    public SelectingView createOverallItemPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(editPath, "SHOW"),
                new AbstractMap.SimpleEntry<>(createPath, "CREATE"))));
    }

    @Override
    public SelectingView createOverallCreaturesPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(createPath, "CREATE"),
                new AbstractMap.SimpleEntry<>(viewPath, "VIEW"))));
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
    public SelectingView createCreatingEditingItemsPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(horsePath, "MOUNT"),
                new AbstractMap.SimpleEntry<>(weaponPath, "WEAPON"),
                new AbstractMap.SimpleEntry<>(armorPath, "ARMOR"))));
    }

    @Override
    public SelectingView createViewingItemsPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(horsePath, "MOUNT"),
                new AbstractMap.SimpleEntry<>(armorPath, "ARMOR"),
                new AbstractMap.SimpleEntry<>(weaponPath, "WEAPON"),
                new AbstractMap.SimpleEntry<>(trolleyPath, "ITEM"))));
    }

    @Override
    public SelectingView createCreaturesPanel() {
        setFactoriesMode(Mode.MENU);
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(monsterPath, "MONSTER"),
                new AbstractMap.SimpleEntry<>(playerImagePath, "PLAYER"),
                new AbstractMap.SimpleEntry<>(npcImage, "NPC"))));
    }

    @Override
    public MainPanelGame createMainPanelGame() {
        setFactoriesMode(Mode.BASIC);
        factory.setButtonFactory(basicButtonFactory);
        factory.setLabelFactory(labelFactory);
        var mainPanel = new MainPanelGame(this);
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
        mainPanel.getGamePanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(moveOption,
                cardOption)));
        mainPanel.getGamePanel().changeActiveOptionsPanel();
        return mainPanel;
    }

    @Override
    public ChoosingCreationGameView createchoosingCreationGameView() {
        setFactoriesMode(Mode.BASIC);
        var panel = new ChoosingCreationGameView(this);
        panel.initialize();
        var p1 = createCreatorPanel();
        var p2 = createCreatorPanel();
        var p3 = createCreatorPanel();
        p1.applyContent(new AbstractMap.SimpleEntry<>(new Vector2(9, 7), playerImagePath),
                new AbstractMap.SimpleEntry<>(new Vector2(3, 4),
                        npcImage), new AbstractMap.SimpleEntry<>(new Vector2(4, 4), npcImage));
        ;
        p2.applyContent(new AbstractMap.SimpleEntry<>(new Vector2(9, 7), playerImagePath),
                new AbstractMap.SimpleEntry<>(new Vector2(3, 4),
                        npcImage), new AbstractMap.SimpleEntry<>(new Vector2(4, 4), npcImage));
        ;
        p1.setWholePanelDisabled();
        p2.setWholePanelDisabled();
        p3.setWholePanelDisabled();
        panel.uploadData(new ArrayList<>(Arrays.asList(p1, p2, p3)));

        return panel;
    }

    public CreatorPanel createCreatorPanel() {
        setFactoriesMode(Mode.BASIC);
        var panel = new CreatorPanel(this, 10);
        panel.initialize();
        panel.setBorder(basicBorderColor, basicBorderSize);
        panel.setBasePath(plusImage);
        return panel;
    }

    @Override
    public CardCancelView createCardCancelView(Card card) {
        setFactoriesMode(Mode.BASIC);
        return new CardCancelView(factory, card);

    }

    @Override
    public CreatorGameView createCreatorGameView() {
        setFactoriesMode(Mode.BASIC);

        var creator = new CreatorGameView(this, 10);
        creator.getCreatorPanel().setBasePath(plusImage);
        creator.getCreatorPanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(monsterPath,
                playerImagePath, npcImage)));
//        creator.getCreatorPanel().
        return creator;
    }


    @Override
    public TitleView createTitleView() {
        factory.setLabelFactory(labelFactory);
        return new TitleView(factory);
    }

    public EntriesCard createEntriesCard() {
        setFactoriesMode(Mode.CLICKED);

        var card = new EntriesCard(factory);
        card.initialize();
        card.setBackgroundImage(cardBackground);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setCancelButtonStatus(true);
        card.setUniformFont();
        return card;
    }

    public BasicCard createBasicCard() {
        setFactoriesMode(Mode.CLICKED);
        var card = new BasicCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        return card;
    }

    @Override
    public GameCard createGameCard() {
        setFactoriesMode(Mode.CLICKED);

        var card = new GameCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
//        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    public EntriesCard createCreatorCard(Card.CardTypes type) {
        setFactoriesMode(Mode.CLICKED);
        var card = new EntriesCard(factory);
        card.initialize();
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        card.initializeCardData();
//        card.uploadCreatorItemsData(generateData1(), type);
        card.setCreatorCard(true, type);
        return card;
    }

    @Override
    public ShowApplyCreatureView createCreatorApplyingCharacterView() {
        setFactoriesMode(Mode.CLICKED);
        var obj = new ShowApplyCreatureView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        obj.uploadData(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("xxx", "xxx")),
                new ArrayList<>(Arrays.asList("xxx", "xxx")), new ArrayList<>(Arrays.asList("xxx", "xxx")),
                new ArrayList<>(Arrays.asList("xxx", "xxx")))));
//        obj.uploadData()
        return obj;
    }

    private OnlyVisibleCard createSmallItemCard(OnlyVisibleCard card) {
        setFactoriesMode(Mode.CLICKED);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, cardBackground);
        card.setBorder(basicBorderColor, basicBorderSize * 2);
        return card;
    }

    @Override
    public FullOnlyVisibleCard createSmallFullCard() {
        setFactoriesMode(Mode.CLICKED);

        var card = new FullOnlyVisibleCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize * 2);
        createSmallCard(card);
        return card;
    }

    @Override
    public OnlyVisibleShowCard createSmallOnlyShowCard() {
        setFactoriesMode(Mode.CLICKED);

        var card = new OnlyVisibleShowCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize * 2);
        createSmallCard(card);
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

    private ShowSmallView createAllItemsView() {
        setFactoriesMode(Mode.CLICKED);
        var obj = new ShowSmallView(this);
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
        var card = createAllItemsView();
        card.uploadMainImageData(armorPath);//todo
        return card;
    }

    public FullSmallView createAllArmorsItemsView() {
        var card = createAllEditableItemsView();
        card.uploadMainImageData(armorPath);
        return card;
    }

    @Override
    public GodCard createGodCard() {
        var card = new GodCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        return card;

    }


    private void createSmallCard(OnlyVisibleCard card) {
        factory.setBorderStrategy(new AverageBorderStartegy());
        card.initialize();
        card.setBorder(basicBorderColor, basicBorderSize);
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));

        mapa.get(0).set(0, StringAdapter.getRelativePath("stats.png"));
        mapa.get(3).set(0, StringAdapter.getRelativePath("gui/guiImages/armor.png"));
        mapa.get(2).set(0, StringAdapter.getRelativePath("weapon.png"));
        mapa.get(1).set(0, StringAdapter.getRelativePath("effect.png"));
        mapa.get(4).set(0, StringAdapter.getRelativePath("horse.png"));
        mapa.get(5).set(0, StringAdapter.getRelativePath("horse.png"));
        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = StringAdapter.getRelativePath("witch.png");

        card.uploadNewData("xxx", "sss");
        card.setUniformFont();
        uploadBackgroundImage(card, cardBackground);

    }
}
