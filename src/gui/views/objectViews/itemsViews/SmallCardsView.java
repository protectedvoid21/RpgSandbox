package gui.views.objectViews.itemsViews;

import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleCard;
import gui.factories.IOverallFactory;
import gui.views.objectViews.AllObjectsView;
import java.util.ArrayList;

public abstract class SmallCardsView extends AllObjectsView {
    protected ArrayList<ArrayList<String>> data = new ArrayList<>();
    protected ArrayList<OnlyVisibleCard> cards = new ArrayList<>();
    private String imageName = "";

    public SmallCardsView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize() {
        initialize(4);
        initializeContent();
        updateContent();
        arrowPanel.updateSwitchingButtons();
    }

    @Override
    protected void initializeContent() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                var panel = createOnlyVisibleCard(j * 2 + i);
                manager.addMiddleComponent(panel.getPanel(), j, 10);
                manager.getMiddleComponent(j, i).addSpace(1);
            }
        }

    }

    public void uploadMainImageData(String path) {
        imageName = path;
        updateContent();
    }

    public void uploadData(ArrayList<ArrayList<String>> data) {
        this.data = data;
        currentSide = 0;
        updateContent();
        arrowPanel.updateSwitchingButtons();
    }

    @Override
    public ArrayList<? extends Object> getData() {
        return data;
    }

    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, Math.min(maxSideIndex, dataSize));

        int currentIndex = 0;
        for (var key : sublist) {
            cards.get(currentIndex).uploadNewData(key.get(0), key.get(1));
            cards.get(currentIndex).uploadTypePathData(imageName);
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

    protected abstract OnlyVisibleCard createOnlyVisibleCard(int index);

}
