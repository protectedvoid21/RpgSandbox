package gui.card;

import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.customUI.customUIStyles.borderStrategies.DefaultBorderStrategy;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.ArrowButtonFactory;
import gui.factories.customFactories.buttonFactories.CardDownPanelButtonFactory;
import gui.factories.customFactories.buttonFactories.WinterClickedButtonFactory;
import gui.factories.customFactories.labelFactories.GameGreenLabelFactory;
import gui.factories.customFactories.labelFactories.TitleCardLabelFactory;
import gui.factories.customFactories.labelFactories.WinterDarkerBackgroundLabelFactory;
import gui.factories.customFactories.textComponentFactory.TextFieldFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WarHammerFactory extends IOverallFactory {

    @Override
    public Card createCard(AbstractMap.SimpleEntry<String, String> titleIconPathName, ArrayList<ArrayList<String>> dataMap
        ) {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
        var card = new GameCard( factory);
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
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(3).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(1).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa;
        data.titleContent = "WITCH";
        data.titlePath = "src/gui/witch.png";


        var c = createCard(new AbstractMap.SimpleEntry<>("src/gui/witch.png", "WITCH"), mapa);//metoda change
        var x = new HashMap<Card.CardTypes, CardContentDataSet>();
        for (var key : Card.CardTypes.values()){
            x.put(key, data);
        }
        c.uploadNewData(x);
        return c;
    }

    @Override
    public OnlyVisibleCard createSmallCard() {
        factory.setButtonFactory(new WinterClickedButtonFactory());
        factory.setBorderStrategy(new AverageBorderStartegy());
        var card = new OnlyVisibleCard(factory, 5);
        var mapa = new ArrayList<ArrayList<String>>();
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));

        mapa.get(0).set(0, "src/gui/stats.png");
        mapa.get(3).set(0, "src/gui/armor.png");
        mapa.get(2).set(0, "src/gui/weapon.png");
        mapa.get(1).set(0, "src/gui/effect.png");
        mapa.get(4).set(0, "src/gui/horse.png");
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
