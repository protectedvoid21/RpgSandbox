package gui.actionListener.basicActionsListener;

import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseListener implements ActionListener {
//    private RoundManager roundManager;
//    private MainPanelGame mainPanelGame;
//    private CustomAudioManager audio;
    private ListenerBaseData listenerBaseData;

    public UseListener(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
//        this.audio = audio;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (listenerBaseData.roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var obj = (Character) listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();
            if (obj.getInventory().getSelectedDisposableItem().getWorkOnEnemy()) {
//                listenerBaseData.audioManager.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
                new UseItemOnEnemyListener(listenerBaseData).actionPerformed(e);
            } else {
                new UseItemOnYourselfListener(listenerBaseData).actionPerformed(e);
//                listenerBaseData.audioManager.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
            }
            listenerBaseData.audioManager.setAudio(obj.getInventory().getSelectedDisposableItem().enumAudio);
        }

    }
}
