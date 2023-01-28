package gui.actionListener;

import com.sun.tools.javac.Main;
import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import gui.views.gamePanel.MainPanelGame;

public class ListenerBaseData {
    public RoundManager roundManager;
    public MainPanelGame mainPanelGame;
    public CustomAudioManager audioManager;
    public boolean isSetItemMode = false;
}
