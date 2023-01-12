package gui.card;

import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleEditCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleShowCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsEditCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsShowCard;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.optionsPanels.GameOptionsPanel;
import gui.views.gamePanel.optionsPanels.OptionsPanel;
import gui.views.objectViews.CardCancelView;
import gui.views.objectViews.CreatorGameView;
import gui.views.objectViews.creatureViews.AllCreaturesEditView;
import gui.views.objectViews.creatureViews.AllCreaturesShowView;
import gui.views.objectViews.creatureViews.ChoosingCreationGameView;
import gui.views.objectViews.itemsViews.AllItemsEditView;
import gui.views.objectViews.itemsViews.AllItemsShowView;
import gui.views.selectingCreatureViews.SelectingView;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DependantHeightBorderStrategy;
import gui.customUI.customUIStyles.borderStrategies.DependantWidthBorderStrategy;
import gui.factories.customFactories.buttonFactories.ButtonFactory;
import gui.factories.customFactories.buttonFactories.MenuButtonsFactory;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.labelFactories.GameGreenLabelFactory;
import gui.factories.customFactories.labelFactories.LabelFactory;
import gui.factories.customFactories.labelFactories.MenuLabelFactory;
import gui.menu.ICustomBackgorund;
import gui.views.menuViews.MenuView;

import java.util.*;

public class WarHammerFactory extends IOverallFactory {
    private ButtonFactory winterFactory = new WinterClickedButtonFactory();
    private LabelFactory labelFactory = new GameGreenLabelFactory();
    private MenuLabelFactory menuLabelFactory = new MenuLabelFactory(0.7, 0.2);
    private MenuButtonsFactory menuButtonsFactory = new MenuButtonsFactory(0.6, 0.2);


    public WarHammerFactory() {
        factory.setButtonFactory(winterFactory);
        factory.setBorderStrategy(new AverageBorderStartegy());
        factory.setLabelFactory(labelFactory);
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
        uploadBackgroundImage(menu, "src/gui/aveeee.jpg");
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
        uploadBackgroundImage(menu, "src/gui/aveeee.jpg");
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
        return createView(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/edit" +
                        ".png", "EDIT"), new AbstractMap.SimpleEntry<>("src/gui/create.png", "CREATE"),
                new AbstractMap.SimpleEntry<>("src/gui/view.png", "VIEW"))));
    }

    @Override
    public SelectingView createCreatingEditingItemsPanel() {
        return createView(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/horse" +
                        ".png", "MOUNT"), new AbstractMap.SimpleEntry<>("src/gui/effect.png", "EFFECTS"),
                new AbstractMap.SimpleEntry<>("src/gui/armor.png", "ARMOR"))));
    }

    @Override
    public SelectingView createViewingItemsPanel() {
        return createView(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/horse" +
                        ".png", "MOUNT"), new AbstractMap.SimpleEntry<>("src/gui/effect.png", "EFFECTS"),
                new AbstractMap.SimpleEntry<>("src/gui/armor.png", "ARMOR"), new AbstractMap.SimpleEntry<>("src/gui" +
                        "/weapon.png", "WEAPON"), new AbstractMap.SimpleEntry<>("src/gui/trolley.png", "ITEM"))));
    }

    @Override
    public SelectingView createCreaturesPanel() {
        return createView(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui/monsterimage" +
                        ".png", "MONSTER"), new AbstractMap.SimpleEntry<>("src/gui/playerimage.png", "PLAYER"),
                new AbstractMap.SimpleEntry<>("src/gui/npcimage.png", "NPC"))));
    }

    @Override
    public MainPanelGame createMainPanelGame() {
        var panel = new MainPanelGame(this);
        panel.initialize();
        return panel;
    }

    @Override
    public ChoosingCreationGameView createchoosingCreationGameView() {
        var panel = new ChoosingCreationGameView(this);
        panel.initialize();
        return panel;
    }

    @Override
    public CardCancelView createCardCancelView(Card card) {
        return new CardCancelView(factory, card);
    }

    @Override
    public CreatorGameView creatorCreatorGameView() {
        return new CreatorGameView(this, 10);
    }


    public EntriesCard createEntriesCard() {
        var card = new EntriesCard(factory);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, "src/gui/aaa.png");//jbc moze byc zle
        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    public BasicCard createBasicCard() {
        factory.setLabelFactory(labelFactory);
        var card = new BasicCard(factory);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, "src/gui/ave.jpg");
        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    @Override
    public GameCard createGameCard() {
        var card = new GameCard(factory);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, "src/gui/ave22.png");
        card.uploadNewData(generateSecondMap(), generateHashMap());
        return card;
    }

    public EntriesCard createCreatorCard(Card.CreatorTypes type) {
        var card = new EntriesCard(factory);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, "src/gui/bob.jpg");
        card.uploadCreatorItemsData(generateData1(), generateData2(), generateData1());
        card.setCreatorCard(true, type);
        return card;
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
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
//        var card = new OnlyVisibleItemCard(factory);
        card.initialize();
        card.setUniformFont();
        uploadBackgroundImage(card, "src/gui/aaa.png");
        return card;
    }

    @Override
    public OnlyVisibleEditCard createSmallEditCard() {
        var card = new OnlyVisibleEditCard(factory, 6);
        createSmallCard(card);
        return card;
    }

    @Override
    public OnlyVisibleShowCard createSmallShowCard() {
        var card = new OnlyVisibleShowCard(factory, 6);
        createSmallCard(card);
        return card;
    }

    @Override
    public AllCreaturesEditView createAllCreatureEditView() {
        var obj = new AllCreaturesEditView(this);
        obj.setBackgroundImage("src/gui/ave.jpg");
        return obj;
    }

    @Override
    public AllCreaturesShowView createAllCreatureShowView() {
        var obj = new AllCreaturesShowView(this);
        obj.setBackgroundImage("src/gui/ave.jpg");
        return obj;
    }

    @Override
    public AllItemsShowView createAllItemsShowView() {
        var obj = new AllItemsShowView(this);
        obj.setBackgroundImage("src/gui/ave.jpg");
        return obj;
    }

    @Override
    public AllItemsEditView createAllItemsEditView() {
        var obj = new AllItemsEditView(this);
        obj.setBackgroundImage("src/gui/ave.jpg");
        return obj;
    }

    @Override
    public OnlyVisibleItemsEditCard createSmallEditItemCard() {
        var card = new OnlyVisibleItemsEditCard(factory);
        createSmallItemCard(card);
        return card;
    }

    @Override
    public OnlyVisibleItemsShowCard createSmallShowItemCard() {
        var card = new OnlyVisibleItemsShowCard(factory);
        createSmallItemCard(card);
        return card;
    }
//    public  OptionsPanel createOptionsPanel(){
//        return new GameOptionsPanel(factory, 5);
//    }

    private void createSmallCard(OnlyVisibleCard card) {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
//        var card = new OnlyVisibleCard(factory, 6);
        card.initialize();
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
        uploadBackgroundImage(card, "src/gui/aaa.png");

    }
}
