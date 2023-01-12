package gui.views.objectViews.itemsViews;

import gui.factories.IOverallFactory;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemCard;
import gui.views.objectViews.AllObjectsView;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AllItemsView extends AllObjectsView {
    protected ArrayList<ArrayList<String>> data = new ArrayList<>();

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
            getCards().get(currentIndex).uploadNewData(key.get(0), key.get(1), key.get(2));
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


    protected abstract OnlyVisibleItemCard createOnlyVisibleCard(int index);


    protected abstract ArrayList<? extends OnlyVisibleItemCard> getCards();
}
