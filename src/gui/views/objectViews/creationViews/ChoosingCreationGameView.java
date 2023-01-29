package gui.views.objectViews.creationViews;

import gui.bundle.CustomBundle;
import gui.data.TextData;
import gui.factories.IOverallFactory;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.AllObjectsView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChoosingCreationGameView extends AllObjectsView {
    protected ArrayList<CreatorPanel> data = new ArrayList<>();
    private final ArrayList<AbstractCustomButton> applyButtons = new ArrayList<>();


    public ChoosingCreationGameView(IOverallFactory factory) {
        super(factory);

    }


    public void initialize() {
        initialize(2);
        initializeSetPanel(2);
        var cmp = manager.getMainComponent(1).getComponent();
        var cmp2 = manager.getMainComponent(2).getComponent();
        initializeContent();
        this.manager.setBackground(new Color(0x367045));
        this.manager.setHasUniqueColor(true);
        updateContent();
        arrowPanel.updateSwitchingButtons();
        manager.getMainComponent(1).changeContent(cmp2);
        manager.getMainComponent(2).changeContent(cmp);

    }

    public void initializeSetPanel(int number){
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        manager.addMainComponent(3);
        for (int i = 0; i<number; i++){
            var button = factory.getFactory().createButton(CustomBundle.getDefaultString(TextData.applyText), null);
            applyButtons.add(button);
            manager.addMiddleComponent(button, 2,10);
            manager.getMiddleComponent(2, i).addSpace(5);
            button.addActionListener(generateActionListener(ButtonType.APPLY, i));
        }
    }



    protected ArrayList<? extends Object> getCards(){
        return data;
    }


    @Override
    protected void initializeContent() {
        for (int j = 0; j < 2; j++) {
            var panel = new ComponentPanelMenager<JComponent>(new JPanel());
            manager.addMiddleComponent(panel, 0, 20);
            manager.getMiddleComponent(0, j).addSpace(1);
            manager.getMiddleComponent(0, j).addSpace(2, ComponentPanelMenager.Side.TOP);
        }

    }

    public void uploadData(ArrayList<CreatorPanel> data) {
        this.data = data;
        currentSide = 0;
        arrowPanel.updateSwitchingButtons();
        updateContent();
    }

    @Override
    public ArrayList<? extends CreatorPanel> getData() {
        return data;
    }
    @Override
    protected void updateContent() {
        int maxSideIndex = getSideMaximumElementsNumber();
        int dataSize = data.size();
        var sublist = data.subList(currentSide * maximumumElements, Math.min(maxSideIndex, dataSize));
        int currentIndex = 0;
        for (var key : sublist) {
            manager.getMiddleComponent(0, currentIndex).changeContent(key.getPanel());
            key.getPanel().setVisible(true);
            currentIndex++;
        }
        setAllowButtonVisibility(true, true);
        if (sublist.size() < maximumumElements) {
            for (int i = dataSize % maximumumElements; i < maximumumElements; i++) {
                manager.getMiddleComponent(0, i).getComponent().setVisible(false);
            }
        }
        setAllowButtonVisibility(dataSize!=0, sublist.size()%maximumumElements==0 && dataSize!=0);

    }

    protected void setAllowButtonVisibility(boolean left, boolean right){
        applyButtons.get(0).setVisible(left);
        applyButtons.get(1).setVisible(right);
    }

}
