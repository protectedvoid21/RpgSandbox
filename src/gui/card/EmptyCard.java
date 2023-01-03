package gui.card;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.factories.GuiFactory;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

import java.util.AbstractMap;
import java.util.ArrayList;

public class EmptyCard extends AbstractCard<AbstractCustomLabel> {
    protected DefaultCustomMenuMenager<AbstractCustomLabel> menager =
            new DefaultCustomMenuMenager<>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    public EmptyCard() {
        super( null);
    }

    @Override
    public DefaultCustomMenuMenager<AbstractCustomLabel> getContentMenager() {
        return menager;
    }

    @Override
    protected void initializeCard(int maximumElementNumber) {
        super.initializeCard(maximumElementNumber);
    }
    protected void updateContent() {
    }

    public void initializeContent() {//zmienia sie
        updateContent();
    }

    @Override
    public void setUniformForm() {

    }
}
