package gui.actionListener;

import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import gui.views.gamePanel.MainPanelGame;

public class ListenerBaseData {
    final public RoundManager roundManager;
    final public MainPanelGame mainPanelGame;
    final public CustomAudioManager audioManager;

    public ListenerBaseData(RoundManager roundManager, MainPanelGame mainPanelGame, CustomAudioManager audioManager) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
        this.audioManager = audioManager;
    }
}
