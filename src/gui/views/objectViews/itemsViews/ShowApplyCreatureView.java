package gui.views.objectViews.itemsViews;

import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.IOverallFactory;
import gui.data.TextData;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import java.util.ArrayList;

public class ShowApplyCreatureView extends ShowSmallView implements TextData {
    private final ArrayList<AbstractCustomButton> applyButtons = new ArrayList<>();
    private final DefaultCustomMenuMenager manager1 =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL, 30);
    private DefaultCustomMenuMenager manager2 =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL, 30);

    public ShowApplyCreatureView(IOverallFactory factory) {
        super(factory);
    }

    public void initialize() {
        initialize(4);
        initializeContent();
        arrowPanel.updateSwitchingButtons();
        getCancelButton().getCustomUI().setOffSet(6);
        initializeSetPanel(0,2, manager1);
        initializeSetPanel(2,4, manager2);

        for (int i = 0; i<2; i++){
            manager1.addMiddleComponent(cards.get(i).getPanel(), 0, 20);
            manager1.getMiddleComponent(0, i%2).addSpace(1);
        }
        for (int i = 2; i<4; i++){
            manager2.addMiddleComponent(cards.get(i).getPanel(), 0, 20);
            manager2.getMiddleComponent(0, i%2).addSpace(1);
        }
        manager.getMainComponent(0).changeContent(manager1.getCmp());
        manager.getMainComponent(1).changeContent(manager2.getCmp());
        updateContent();


    }

    @Override
    protected void updateContent() {
        super.updateContent();
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, Math.min(maxSideIndex, dataSize));


        for (var button : applyButtons) {
           button.setVisible(true);
        }
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                applyButtons.get(i).setVisible(false);
            }
        }
    }

    private void initializeSetPanel(int number,int end, DefaultCustomMenuMenager man) {
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        man.addMainComponent(12);
        man.addMainComponent(3);
        for (int i = number; i < end; i++) {
            var button = factory.getFactory().createButton(applyText, null);
            button.getCustomUI().setOffSet(4);
            applyButtons.add(button);
            man.addMiddleComponent(button, 1, 10);
            man.getMiddleComponent(1, i-number).addSpace(5);
            button.addActionListener(generateActionListener(ButtonType.APPLY, i));
        }
    }
}
