package gui.factories;

import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleEditCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleCreatureCards.OnlyVisibleShowCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsEditCard;
import gui.card.fullCards.specificCards.onlyVisibleCards.onlyVisibleItemsCards.OnlyVisibleItemsShowCard;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.CreatorPanel;
import gui.views.CardCancelView;
import gui.views.objectViews.creationViews.CreatorGameView;
import gui.views.objectViews.creatureViews.AllCreaturesEditView;
import gui.views.objectViews.creatureViews.AllCreaturesShowView;
import gui.views.objectViews.creationViews.ChoosingCreationGameView;
import gui.views.objectViews.itemsViews.AllItemsEditView;
import gui.views.objectViews.itemsViews.AllItemsShowView;
import gui.views.menuViews.SelectingView;
import gui.card.fullCards.abstractCards.Card;
import gui.card.fullCards.specificCards.*;
import gui.views.menuViews.MenuView;

public abstract class IOverallFactory {
    protected GuiFactory factory = new GuiFactory();

//    public abstract Card createCard();

//    public abstract Card createFullCard();

    public abstract EntriesCard createEntriesCard();

    public abstract BasicCard createBasicCard();

    public abstract GameCard createGameCard();

    public abstract OnlyVisibleEditCard createSmallEditCard();

    public abstract OnlyVisibleShowCard createSmallShowCard();

    public abstract OnlyVisibleItemsEditCard createSmallEditItemCard();

    public abstract OnlyVisibleItemsShowCard createSmallShowItemCard();

    public abstract AllCreaturesEditView createAllCreatureEditView();

    public abstract AllCreaturesShowView createAllCreatureShowView();

    public abstract AllItemsShowView createAllItemsShowView();

    public abstract AllItemsEditView createAllItemsEditView();

    public abstract EntriesCard createCreatorCard(Card.CreatorTypes type);

    public abstract MenuView createMenuView();

    public GuiFactory getFactory() {
        return factory;
    }

    public abstract SelectingView createOverallPanel();

    public abstract SelectingView createCreatingEditingItemsPanel();

    public abstract SelectingView createViewingItemsPanel();

    public abstract SelectingView createCreaturesPanel();

    public abstract MainPanelGame createMainPanelGame();

    public abstract ChoosingCreationGameView createchoosingCreationGameView();

    public abstract CardCancelView createCardCancelView(Card card);

    public abstract CreatorGameView createCreatorGameView();

//    public abstract CreatorPanel createCreatorPanel();
//    public abstract OptionsPanel createOptionsPanel();
}
