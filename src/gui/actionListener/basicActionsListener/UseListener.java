package gui.actionListener.basicActionsListener;

import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseListener implements ActionListener {
    private RoundManager roundManager;
    private MainPanelGame mainPanelGame;
    private CustomAudioManager audio;

    public UseListener(RoundManager roundManager, MainPanelGame mainPanelGame, CustomAudioManager audio) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
        this.audio = audio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var obj = (Character) roundManager.getGameObjectWithTurn().getCreature();
            if (obj.getInventory().getSelectedDisposableItem().getWorkOnEnemy()) {
                audio.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
                new UseItemOnEnemyListener(roundManager, mainPanelGame, audio).actionPerformed(e);
            } else {
                new UseItemOnYourselfListener(roundManager, mainPanelGame, audio).actionPerformed(e);
                audio.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
            }
        }

    }
}
