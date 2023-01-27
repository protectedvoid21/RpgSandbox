package gui.factories;

import controllers.utils.CreatureType;
import gui.card.fullCards.specificCards.onlyVisibleCards.FullOnlyVisibleCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.OnlyVisibleShowCard;
import gui.views.TitleView;
import gui.views.gamePanel.MainPanelGame;
import gui.views.CardCancelView;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.creationViews.ChoosingCreationGameView;
import gui.views.objectViews.itemsViews.ShowApplyCreatureView;
import gui.views.menuViews.SelectingView;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.views.menuViews.MenuView;
import gui.views.objectViews.itemsViews.FullSmallView;
import gui.views.objectViews.itemsViews.ShowSmallView;

public abstract class IOverallFactory {
    protected GuiFactory factory = new GuiFactory();

    public abstract EntriesCard createEntriesCard();

    public abstract BasicCard createBasicCard();

    public abstract GameCard createGameCard();


    public abstract FullOnlyVisibleCard createSmallFullCard();

    public abstract OnlyVisibleShowCard createSmallOnlyShowCard();

    public abstract FullSmallView createAllMonstersView();
    public abstract FullSmallView createAllNPCView();
    public abstract FullSmallView createAllCharactersView();


    public abstract FullSmallView createAllWeaponsItemsView();
    public abstract FullSmallView createAllMountsItemsView();
    public abstract FullSmallView createAllArmorsItemsView();
    public abstract GodCard createGodCard();
    public abstract EntriesCard createCreatorCard(Card.CardTypes type);

    public abstract ShowApplyCreatureView createCreatorApplyingCharacterView(CreatureType type);

    public abstract MenuView createMenuView();

    public GuiFactory getFactory() {
        return factory;
    }

    public abstract SelectingView createOverallItemPanel();
    public abstract SelectingView createOverallCreaturesPanel();


    public abstract SelectingView createViewingItemsPanel();

    public abstract SelectingView createCreaturesPanel();

    public abstract MainPanelGame createMainPanelGame();

    public abstract ChoosingCreationGameView createchoosingCreationGameView();


    public abstract CreatorGameView createCreatorGameView();

    public abstract CreatorPanel createCreatorPanel();
}
