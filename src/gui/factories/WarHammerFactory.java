package gui.factories;

import gui.card.CardContentDataSet;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleEditCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleShowCard;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.factories.customFactories.buttonFactories.*;
import gui.factories.customFactories.labelFactories.*;
import gui.factories.customFactories.textComponentFactory.TextFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;
import gui.views.Point;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.CardCancelView;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.creatureViews.AllCreaturesEditView;
import gui.views.objectViews.creatureViews.AllCreaturesShowView;
import gui.views.objectViews.creationViews.ChoosingCreationGameView;
import gui.views.objectViews.creatureViews.ShowApplyCreatureView;
import gui.views.menuViews.SelectingView;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantWidthBorderStrategy;
import gui.menu.ICustomBackgorund;
import gui.views.menuViews.MenuView;
import gui.views.objectViews.itemsViews.AllItemsView;

import java.awt.*;
import java.util.*;

public class WarHammerFactory extends IOverallFactory implements WarhammerData {
    private ButtonFactory basicButtonFactory = new BasicButton();
    private LabelFactory labelFactory = new BasicLabelFactory();
    private LabelFactory clickedLabelFactory = new ClickedLabelFactory();
    private ClickedWarhammerBasicFactory clickedFactoryButton = new ClickedWarhammerBasicFactory();
    private MenuLabelFactory menuLabelFactory = new MenuLabelFactory(0.7, 0.2);
    private MenuButtonsFactory menuButtonsFactory = new MenuButtonsFactory(0.6, 0.2);
    private TextFactory textFactory = new TextFieldFactory();


    public WarHammerFactory() {
        factory.setSpecificFont(fontPath, 14);
        factory.setButtonFactory(basicButtonFactory);
        factory.setBorderStrategy(new AverageBorderStartegy());
        factory.setLabelFactory(labelFactory);
        factory.setTextFactory(textFactory);
    }

    private void uploadBackgroundImage(ICustomBackgorund object, String path) {
        object.setBackgroundImage(path);
    }

    @Override
    public MenuView createMenuView() {
        factory.setBorderStrategy(new DependantHeightBorderStrategy());

        menuButtonsFactory.setPaths("src/gui/swo.png", "src/gui/swo.png");
        menuLabelFactory.setPaths("src/gui/leftsword.png", "src/gui/rightsword.png");
        factory.setLabelFactory(menuLabelFactory);
        factory.setButtonFactory(menuButtonsFactory);
        var menu = new MenuView(factory);
        menu.setBorder(basicBorderColor, basicBorderSize);
        uploadBackgroundImage(menu, background1);
        return menu;
    }

    private SelectingView createView(ArrayList<AbstractMap.SimpleEntry<String, String>> content) {
        factory.setBorderStrategy(new DependantWidthBorderStrategy());
        menuButtonsFactory.setPaths("", "");
        factory.setLabelFactory(menuLabelFactory);
        menuLabelFactory.setPaths("", "");
        factory.setButtonFactory(menuButtonsFactory);
//        var menu = new SelectingView(factory,new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>
//        ("src/gui/monsterimage" +
//                        ".png", "MONSTER"), new AbstractMap.SimpleEntry<>("src/gui/playerimage.png", "PLAYER"),
//                new AbstractMap.SimpleEntry<>("src/gui/npcimage.png", "NPC"))));
        var menu = new SelectingView(factory, content);
        menu.setBorder(basicBorderColor, basicBorderSize);
        uploadBackgroundImage(menu, background1);
        factory.setBorderStrategy(new AverageBorderStartegy());
        return menu;
    }

//    @Override
//    public SelectingView createSelectingView() {
//        factory.setBorderStrategy(new DependantHeightBorderStrategy());
//        menuButtonsFactory.setPaths("", "");
//        factory.setLabelFactory(menuLabelFactory);
//        menuLabelFactory.setPaths("", "");
//        factory.setButtonFactory(menuButtonsFactory);
//        var menu = new SelectingView(factory,new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>
//        ("src/gui/monsterimage" +
//                        ".png", "MONSTER"), new AbstractMap.SimpleEntry<>("src/gui/playerimage.png", "PLAYER"),
//                new AbstractMap.SimpleEntry<>("src/gui/npcimage.png", "NPC"))));
////        menuButtonsFactory.setPaths("src/gui/undoleft.png", "src/gui/undoright.png");
////        menu.createReturnButton();
//        uploadBackgroundImage(menu,"src/gui/aveeee.jpg");
//        return menu;
//    }

    @Override
    public SelectingView createOverallPanel() {
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(editPath, "EDIT"),
                new AbstractMap.SimpleEntry<>(createPath, "CREATE"),
                new AbstractMap.SimpleEntry<>(viewPath, "VIEW"))));
    }

    @Override
    public SelectingView createCreatingEditingItemsPanel() {
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(horsePath + ".png", "MOUNT"),
                new AbstractMap.SimpleEntry<>(efectPath, "EFFECTS"),
                new AbstractMap.SimpleEntry<>(armorPath, "ARMOR"))));
    }

    @Override
    public SelectingView createViewingItemsPanel() {
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(horsePath, "MOUNT"),
                new AbstractMap.SimpleEntry<>(efectPath, "EFFECTS"),
                new AbstractMap.SimpleEntry<>(armorPath, "ARMOR"),
                new AbstractMap.SimpleEntry<>(weaponPath, "WEAPON"), 
                new AbstractMap.SimpleEntry<>(trolleyPath, "ITEM"))));
    }

    @Override
    public SelectingView createCreaturesPanel() {
        return createView(new ArrayList<>(Arrays.asList(
                new AbstractMap.SimpleEntry<>(monsterPath, "MONSTER"),
                new AbstractMap.SimpleEntry<>(playerImagePath, "PLAYER"),
                new AbstractMap.SimpleEntry<>(npcImage, "NPC"))));
    }

    @Override
    public MainPanelGame createMainPanelGame() {
        factory.setButtonFactory(basicButtonFactory);
        factory.setLabelFactory(labelFactory);
        var mainPanel = new MainPanelGame(this);
        mainPanel.getGamePanel().setBorder(basicBorderColor, basicBorderSize);
        mainPanel.getActivityOptionsPanel().initializeButtonsData(new ArrayList<>(Arrays.asList(monsterPath,
                playerImagePath, npcImage, playerImagePath,
                npcImage, npcImage)));
        mainPanel.getActivityOptionsPanel().initializeLabelsData(new ArrayList<>(Arrays.asList("1", "2", "3", "1", "1"
                , "1")));
        mainPanel.getGamePanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(monsterPath,
                playerImagePath, npcImage, playerImagePath,
                npcImage, npcImage)));
        mainPanel.getGamePanel().initializeOptionsPanelLabelData(new ArrayList<>(Arrays.asList("1", "3", "0", "1", "2"
        )));
        return mainPanel;
    }

    @Override
    public ChoosingCreationGameView createchoosingCreationGameView() {
        var panel = new ChoosingCreationGameView(this);
        panel.initialize();
        var p1 = createCreatorPanel();
        var p2 = createCreatorPanel();
        var p3 = createCreatorPanel();
        p1.setWholePanelDisabled();
        p2.setWholePanelDisabled();
        p3.setWholePanelDisabled();
        p1.applyContent(new AbstractMap.SimpleEntry<>(new Point(9, 7),playerImagePath),
                new AbstractMap.SimpleEntry<>(new Point(3, 4),
                        npcImage), new AbstractMap.SimpleEntry<>(new Point(4, 4), npcImage))
        ;
        panel.uploadData(new ArrayList<>(Arrays.asList(p1, p2, p3)));

        return panel;
    }

    private CreatorPanel createCreatorPanel() {
        var panel = new CreatorPanel(this, 10);
        panel.initialize();
        panel.setBorder(basicBorderColor, basicBorderSize);
        panel.setBasePath(plusImage);
        return panel;
    }

    @Override
    public CardCancelView createCardCancelView(Card card) {
        return new CardCancelView(factory, card);

    }

    @Override
    public CreatorGameView createCreatorGameView() {
        factory.setButtonFactory(basicButtonFactory);
        factory.setLabelFactory(labelFactory);
        var creator = new CreatorGameView(this, 10);
        creator.getCreatorPanel().setBasePath(plusImage);
        creator.getCreatorPanel().initializeOptionsButtonPanelData(new ArrayList<>(Arrays.asList(monsterPath, playerImagePath, npcImage)));
        return creator;
    }


    public EntriesCard createEntriesCard() {
        factory.setLabelFactory(clickedLabelFactory);
        factory.setButtonFactory(clickedFactoryButton);
        var card = new EntriesCard(factory);
        card.setBackgroundImage(cardBackground);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.initialize();
        card.setCancelButtonStatus(true);
        card.setUniformFont();
        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    public BasicCard createBasicCard() {
        factory.setLabelFactory(clickedLabelFactory);
        factory.setButtonFactory(clickedFactoryButton);
        var card = new BasicCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
//        card.setBackground(new Color(0x9A76F5));
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        card.uploadNewData(generateSecondMap(), generateHashMap());
//        card.setBorder(basicBorderColor, basicBorderSize);
//        card.setBackgroundImage(cardBackground);
//        card.initialize();
//        card.setUniformFont();
//        card.setCancelButtonStatus(true);
//        card.uploadCreatorItemsData(generateData1(), generateData2(), generateData1());
//        card.setCreatorCard(true, Card.CreatorTypes.ARMOR);
        return card;
    }

    @Override
    public GameCard createGameCard() {
        factory.setLabelFactory(clickedLabelFactory);
        factory.setButtonFactory(clickedFactoryButton);
        var card = new GameCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    public EntriesCard createCreatorCard(Card.CreatorTypes type) {
        factory.setLabelFactory(clickedLabelFactory);
        factory.setButtonFactory(clickedFactoryButton);
        var card = new EntriesCard(factory);
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setBackgroundImage(cardBackground);
        card.initialize();
        card.setUniformFont();
        card.setCancelButtonStatus(true);
        card.uploadCreatorItemsData(generateData1(), generateData2(), generateData1());
        card.setCreatorCard(true, type);
        return card;
    }

    @Override
    public ShowApplyCreatureView createCreatorApplyingCharacterView() {
        var obj = new ShowApplyCreatureView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        return obj;
    }


    private CardContentDataSet generateData2() {
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));


        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        var mapa2 = new ArrayList<ArrayList<String>>();
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRdfgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDdfgdfgDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAdfsdfM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOfdgfC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWdfgdfgER", "1dfdgdf0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDfgfggDD", "1fgdfgdfgf0"})));


        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(1).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(3).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";
        data.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));

        CardContentDataSet data2 = new CardContentDataSet();
        data2.content = mapa2;
        data2.titleContent = "WITCH";
        data2.titlePath = "src/gui/witch.png";
        data2.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));


        var x = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
            x.put(key, data);
        }
        var hash = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        for (var type : Arrays.asList(Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS, Card.CardTypes.EFFECTS,
                Card.CardTypes.ARMOR, Card.CardTypes.ITEMS)) {
            hash.put(type, new ArrayList<>(Arrays.asList(data2, data, data, data2, data2, data2, data2, data2, data2,
                    data2,
                    data2, data, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2,
                    data2, data2,
                    data2, data2, data2, data2, data, data, data, data, data, data, data, data, data, data, data,
                    data, data, data, data, data, data, data, data, data, data)));
        }

        return data2;
    }

    private CardContentDataSet generateData1() {
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));


        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        var mapa2 = new ArrayList<ArrayList<String>>();
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRdfgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDdfgdfgDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAdfsdfM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOfdgfC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWdfgdfgER", "1dfdgdf0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDfgfggDD", "1fgdfgdfgf0"})));


        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(1).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(3).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";
        data.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));

        CardContentDataSet data2 = new CardContentDataSet();
        data2.content = mapa2;
        data2.titleContent = "WITCH";
        data2.titlePath = "src/gui/witch.png";
        data2.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));


        var x = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
            x.put(key, data);
        }
        var hash = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        for (var type : Arrays.asList(Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS, Card.CardTypes.EFFECTS,
                Card.CardTypes.ARMOR, Card.CardTypes.ITEMS)) {
            hash.put(type, new ArrayList<>(Arrays.asList(data2, data, data, data2, data2, data2, data2, data2, data2,
                    data2,
                    data2, data, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2,
                    data2, data2,
                    data2, data2, data2, data2, data, data, data, data, data, data, data, data, data, data, data,
                    data, data, data, data, data, data, data, data, data, data)));
        }

        return data;
    }

    private LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>> generateHashMap() {
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));


        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        var mapa2 = new ArrayList<ArrayList<String>>();
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRdfgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDdfgdfgDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAdfsdfM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOfdgfC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWdfgdfgER", "1dfdgdf0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDfgfggDD", "1fgdfgdfgf0"})));


        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(1).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(3).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";
        data.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));

        CardContentDataSet data2 = new CardContentDataSet();
        data2.content = mapa2;
        data2.titleContent = "WITCH";
        data2.titlePath = "src/gui/witch.png";
        data2.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));


        var x = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
            x.put(key, data);
        }
        var hash = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        for (var type : Arrays.asList(Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS, Card.CardTypes.EFFECTS,
                Card.CardTypes.ARMOR, Card.CardTypes.ITEMS)) {
            hash.put(type, new ArrayList<>(Arrays.asList(data2, data, data, data2, data2, data2, data2, data2, data2,
                    data2,
                    data2, data, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2,
                    data2, data2,
                    data2, data2, data2, data2, data, data, data, data, data, data, data, data, data, data, data,
                    data, data, data, data, data, data, data, data, data, data)));
        }

        return hash;
    }

    public LinkedHashMap<Card.CardTypes, CardContentDataSet> generateSecondMap() {
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));


        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        var mapa2 = new ArrayList<ArrayList<String>>();
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRdfgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDdfgdfgDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAdfsdfM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOfdgfC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWdfgdfgER", "1dfdgdf0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRgdfgYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDfgfggDD", "1fgdfgdfgf0"})));


        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa2.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(1).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(3).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";
        data.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));

        CardContentDataSet data2 = new CardContentDataSet();
        data2.content = mapa2;
        data2.titleContent = "WITCH";
        data2.titlePath = "src/gui/witch.png";
        data2.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.STRING, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.BOOLEAN,
                CardContentDataSet.DataType.BOOLEAN, CardContentDataSet.DataType.STRING));


        var x = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
            x.put(key, data);
        }
        var hash = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        for (var type : Arrays.asList(Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS, Card.CardTypes.EFFECTS,
                Card.CardTypes.ARMOR, Card.CardTypes.ITEMS)) {
            hash.put(type, new ArrayList<>(Arrays.asList(data2, data, data, data2, data2, data2, data2, data2, data2,
                    data2,
                    data2, data, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2,
                    data2, data2,
                    data2, data2, data2, data2, data, data, data, data, data, data, data, data, data, data, data,
                    data, data, data, data, data, data, data, data, data, data)));
        }

        return x;
    }


    private OnlyVisibleItemCard createSmallItemCard(OnlyVisibleItemCard card) {
        factory.setButtonFactory(clickedFactoryButton);
        factory.setLabelFactory(clickedLabelFactory);
        card.initialize();
        card.setBorder(basicBorderColor, basicBorderSize);
        card.setUniformFont();
        uploadBackgroundImage(card, cardBackground);
        return card;
    }

    @Override
    public OnlyVisibleEditCard createSmallEditCard() {
        factory.setButtonFactory(clickedFactoryButton);
        factory.setLabelFactory(clickedLabelFactory);
        var card = new OnlyVisibleEditCard(factory, 6);
        card.setBorder(basicBorderColor, basicBorderSize);
        createSmallCard(card);
        return card;
    }

    @Override
    public OnlyVisibleShowCard createSmallShowCard() {
        factory.setButtonFactory(clickedFactoryButton);
        factory.setLabelFactory(clickedLabelFactory);
        var card = new OnlyVisibleShowCard(factory, 6);
        card.setBorder(basicBorderColor, basicBorderSize);
        createSmallCard(card);
        return card;
    }

    @Override
    public AllCreaturesEditView createAllCreatureEditView() {
        var obj = new AllCreaturesEditView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        return obj;
    }

    @Override
    public AllCreaturesShowView createAllCreatureShowView() {
        var obj = new AllCreaturesShowView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        return obj;
    }

    @Override
    public AllItemsView createAllItemsShowView() {
        factory.setButtonFactory(clickedFactoryButton);
        factory.setLabelFactory(clickedLabelFactory);
        var obj = new AllItemsView(this);
        obj.initialize();
        obj.setBackgroundImage(avePath);
        return obj;
    }

    @Override
    public OnlyVisibleItemCard createSmallItemCard() {
        var card = new OnlyVisibleItemCard(factory);
        createSmallItemCard(card);
        card.setBorder(basicBorderColor, basicBorderSize);
        return card;
    }
//    public  OptionsPanel createOptionsPanel(){
//        return new GameOptionsPanel(factory, 5);
//    }

    private void createSmallCard(OnlyVisibleCard card) {
        factory.setBorderStrategy(new AverageBorderStartegy());
//        var card = new OnlyVisibleCard(factory, 6);
        card.initialize();
        card.setBorder(basicBorderColor, basicBorderSize);
//        card.uploadNewData("src/gui/stats.png", "bandage", "src/gui/stats.png");
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(3).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(1).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");
        mapa.get(5).set(0, "src/gui/horse.png");
        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";

        card.uploadNewData(data);
        card.setUniformFont();
        uploadBackgroundImage(card, cardBackground);

    }
}
