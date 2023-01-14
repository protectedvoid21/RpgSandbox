package game.interfaces;

import game.board.RoundManager;
import gui.views.gamePanel.MainPanelGame;

public interface ITurnOffButtons {
    void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame,Integer parametr, Integer usedIndex);
}
