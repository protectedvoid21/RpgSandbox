package gui.card;

import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;

import java.awt.*;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WarHammerFactory extends IOverallFactory {

    @Override
    public Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName,
                           ArrayList<ArrayList<String>> dataMap
    ) {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
        var card = new ChoserCard(factory);
        card.initialize();
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
//        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
//        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(3).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(1).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";
        data.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.BOOLEAN,
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
        var x = new HashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()) {
            if (key == Card.CardTypes.MOUNT)
                x.put(key, data);
        }
        c.uploadNewData(x);
        c.uploadCreatorItemsData(data, data, data);
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
