package gui.card;

import gui.card.contentCards.detailCards.AddingButtonCard;
import gui.card.contentCards.detailCards.AddingItemButtonCard;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public class WarHammerFactory extends IOverallFactory {

    @Override
    public Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                           ArrayList<ArrayList<String>> dataMap
    ) {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
        var card = new EntriesCard(factory);
        card.initialize();
//        card.setCreatorCard(true, Card.CreatorTypes.ARMOR);
//        card.setCancelButtonStatus(true);
        card.setUniformFont();
        try {
            card.setBackgroundImage("src/gui/aaa.png");
        } catch (IOException e) {
            card.setBackgroundColor(new Color(0x935D3A));
        }
        return card;
    }

    @Override
    public Card createFullCard() {
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
//        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
//        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(1).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(3).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

//        mapa2.get(0).set(0, "src/gui/stats.png");
//        mapa2.get(3).set(0, "src/gui/armor.png");
//        mapa2.get(2).set(0, "src/gui/weapon.png");
//        mapa2.get(1).set(0, "src/gui/effect.png");
//        mapa2.get(4).set(0, "src/gui/horse.png");
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


        var c = createCard(new AbstractMap.SimpleEntry<>("src/gui/witch.png", "WITCH"), mapa);//metoda change

        var x = new LinkedHashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
//            if (key == Card.CardTypes.MOUNT)
                x.put(key, data);
        }
//        System.out.println(x+"xd");
        var hash = new LinkedHashMap<Card.CardTypes, ArrayList<CardContentDataSet>>();
        for (var type : Arrays.asList(Card.CardTypes.MOUNT, Card.CardTypes.WEAPONS, Card.CardTypes.EFFECTS,
                Card.CardTypes.ARMOR, Card.CardTypes.ITEMS)) {
            hash.put(type, new ArrayList<>(Arrays.asList(data2, data, data, data2, data2, data2, data2, data2, data2, data2,
                    data2, data, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2, data2,
                    data2, data2, data2, data2, data, data, data, data, data,  data, data, data, data, data, data,
                    data, data, data, data, data, data, data, data, data, data)));
        }

        c.uploadNewData(x, hash);
        c.uploadCreatorItemsData(data, data, data);
//        c.setCreatorCard(true, Card.CreatorTypes.ARMOR);
//        c.setCreatorCard(true, Card.CreatorTypes.MOUNT);

        return c;
    }

    @Override
    public OnlyVisibleCard createSmallCard() {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
        var card = new OnlyVisibleCard(factory, 6);
        card.initialize();
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
        try {
            card.setBackgroundImage("src/gui/aaa.png");
        } catch (IOException e) {
            card.setBackgroundColor(new Color(0x935D3A));
        }

        return card;


    }
}
