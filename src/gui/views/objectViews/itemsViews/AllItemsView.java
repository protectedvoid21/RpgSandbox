package gui.views.objectViews.itemsViews;

import gui.card.DoubleArrowPanel;
import gui.factories.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.views.objectViews.AllObjectsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AllItemsView extends AllObjectsView {
    protected ArrayList<ArrayList<String>> data = new ArrayList<>();
    private ArrayList<OnlyVisibleItemCard> cards = new ArrayList<>();

    public AllItemsView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize(){
        this.data = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("hah", "xd", "xxxx")),
                new ArrayList<>(Arrays.asList("hah", "xd", "xxxx")), new ArrayList<>(Arrays.asList("hah", "xgdgd",
                        "xxxx")),
                new ArrayList<>(Arrays.asList("hah", "xd", "xxxfgdfgx")), new ArrayList<>(Arrays.asList("hah", "xd",
                        "xgdfgxxx")),
                new ArrayList<>(Arrays.asList("hah", "gfdgdxd", "xxfgdfxx")), new ArrayList<>(Arrays.asList("hah",
                        "xd", "xxxx")),
                new ArrayList<>(Arrays.asList("hdfgdah", "xdfgdgd", "xdgdfgxxx")), new ArrayList<>(Arrays.asList(
                        "hagdgh", "xd", "xxxx"))))
        ;
        initialize(4);
        initializeContent();
        updateContent();
        arrowPanel.updateSwitchingButtons();
    }

    @Override
    protected void initializeContent() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                var panel = createOnlyVisibleCard(j*2+i);
                manager.addMiddleComponent(panel.getPanel(), j, 10);
                manager.getMiddleComponent(j, i).addSpace(1);
            }
        }

    }

    public void uploadData(ArrayList<ArrayList<String>> data) {
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
            cards.get(currentIndex).uploadNewData(key.get(0), key.get(1), key.get(2));
            currentIndex++;
        }
        for (var card : cards) {
            card.getPanel().setVisible(true);
        }
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                cards.get(i).getPanel().setVisible(false);
            }
        }

    }


    protected OnlyVisibleItemCard createOnlyVisibleCard(int index){
        var card = factory.createSmallItemCard();
        card.getShowbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.SHOW)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.SHOW).actionPerformed(e);
                }
            }
        });
        card.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.EDIT)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.EDIT).actionPerformed(e);
                }
            }
        });
        card.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedIndex = maximumumElements * currentSide + index;
                if (listenerHashMap.containsKey(clickedIndex) && listenerHashMap.get(clickedIndex).containsKey(ButtonType.DELETE)) {
                    listenerHashMap.get(clickedIndex).get(ButtonType.DELETE).actionPerformed(e);
                }
                data.remove(data.get(clickedIndex));
                updateContent();
                if (maximumumElements * currentSide >= data.size()) {
                    switchSide(DoubleArrowPanel.Side.LEFT);
                    arrowPanel.updateSwitchingButtons();
                }
            }
        });
        cards.add(card);
        return card;
    }


//    protected ArrayList<? extends OnlyVisibleItemCard> getCards(){
//        return cards;
//    }
}
