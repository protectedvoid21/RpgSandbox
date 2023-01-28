package gui.card.contentCards;

import gui.customComponents.abstractComponents.AbstractCustomLabel;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;

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
    @Override
    public void initializeCard() {

    }
}
