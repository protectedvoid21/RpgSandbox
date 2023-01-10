package gui.views.objectViews.creatureViews;

import gui.card.CardContentDataSet;
import gui.card.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleCard;
import gui.menu.ComponentPanelMenager;
import gui.views.objectViews.AllObjectsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class AllCreaturesView extends AllObjectsView {
    protected ArrayList<CardContentDataSet> data = new ArrayList<>();


    public AllCreaturesView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize() {
        initialize(2);
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

        var mapa3 = new ArrayList<ArrayList<String>>();

        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATRdfgdfgYBUT1", "10"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"XDdfgdfgDD", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAdfsdfM", "10f"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"MOfdgfC", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"POWdfgdfgER", "1dfdgdf0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATRgdfgYBUT1", "10"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"XDfgfggDD", "1fgdfgdfgf0"})));


        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"DEFENSIVESKILLS", "1f0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ARMOR", "1f0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATRYBUT1", "10"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"XDDD", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"COSTAM", "10f"})));

        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"MOC", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"ATACK", "1fd0"})));
        mapa3.add(new ArrayList<>(Arrays.asList(new String[]{"POWER", "1df0"})));

        CardContentDataSet data = new CardContentDataSet();
        data.content = mapa2;
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

        var data2 = new CardContentDataSet();

        data2.content = mapa3;
        data2.titleContent = "WITCH";
        data2.titlePath = "src/gui/witch.png";
        data2.dataType = new ArrayList<>(Arrays.asList(CardContentDataSet.DataType.STRING,
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

        this.data = new ArrayList<>(Arrays.asList(data, data, data2, data2, data, data, data, data, data, data, data,
                data, data));
        this.data.get(3).content.get(2).set(1, "fsd");
        initializeContent();
        updateContent();
        arrowPanel.updateSwitchingButtons();
    }

    protected abstract OnlyVisibleCard createOnlyVisibleCard(int index);

    protected abstract ArrayList<? extends OnlyVisibleCard> getCards();


    @Override
    protected void initializeContent() {
        for (int j = 0; j < 2; j++) {
            var panel = createOnlyVisibleCard(j);
            manager.addMiddleComponent(panel.getPanel(), 0, 20);
            manager.getMiddleComponent(0, j).addSpace(1);
            manager.getMiddleComponent(0, j).addSpace(2, ComponentPanelMenager.Side.TOP);
        }

    }

    public void uploadData(ArrayList<CardContentDataSet> data) {
        this.data = data;
        currentSide = 0;
        updateContent();
    }

    @Override
    public ArrayList<? extends Object> getData() {
        return data;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, maxSideIndex > dataSize ? dataSize :
                maxSideIndex);

        int currentIndex = 0;
        for (var key : sublist) {
            getCards().get(currentIndex).uploadNewData(key);
            currentIndex++;
        }
        for (var card : getCards()) {
            card.getPanel().setVisible(true);
        }
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                getCards().get(i).getPanel().setVisible(false);
            }
        }

    }
}
