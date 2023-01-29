package gui.views.objectViews.creationViews;

import gui.bundle.CustomBundle;
import gui.data.TextData;
import gui.factories.IOverallFactory;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.views.gamePanel.gamePanels.CreatorPanel;

import java.awt.*;

public class CreatorGameView implements TextData {
    private CreatorPanel panel;
    private DefaultCustomMenuMenager manager =
            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.VERTICAL,
                    ComponentsSeries.ComponentsDimension.HORIZONTAL);
    private AbstractCustomButton exitButton;
    private AbstractCustomButton saveButton;

    public CreatorGameView(IOverallFactory factory, int size) {
        panel = new CreatorPanel(factory, size);
        panel.initialize();
        manager.addMainComponent(9);
        manager.addMainComponent(1);
        manager.addMiddleComponent(panel.getPanel(), 0,10);
        factory.getFactory().setButtonFactory(new BasicButton());
        factory.getFactory().setButtonType(GuiFactory.ButtonType.NORMAL);
        saveButton = factory.getFactory().createButton(CustomBundle.getString(saveText), null);
        exitButton = factory.getFactory().createButton(CustomBundle.getString(exitText), null);
        manager.addMiddleComponent(saveButton, 1, 10);
        manager.getMainComponent(1).addSpace(6, ComponentPanelMenager.Side.LEFT, ComponentPanelMenager.Side.RIGHT);
        manager.getMainComponent(1).addSpace(3, ComponentPanelMenager.Side.BOTTOM, ComponentPanelMenager.Side.TOP);
        manager.addMiddleComponent(exitButton, 1, 10);
        manager.getMiddleComponent(1, 0).addSpace(3, ComponentPanelMenager.Side.RIGHT);
        manager.getMiddleComponent(1, 1).addSpace(3, ComponentPanelMenager.Side.LEFT);
        manager.setBackground(new Color(0xA25F5F));
        manager.setHasUniqueColor(true);

    }

    public CreatorPanel getCreatorPanel(){
        return panel;
    }

    public AbstractCustomButton getExitButton(){
        return exitButton;
    }
    public AbstractCustomButton getSaveButton(){
        return saveButton;
    }

    public ComponentPanelMenager getPanel(){
        return manager.getCmp();
    }
}
