package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowDescripton implements ActionListener {

//    RoundManager roundManager;
//    MainPanelGame mainPanelGame;

    private ListenerBaseData listenerBaseData;
    public ShowDescripton(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();
        ArrayList<String> popUp = new ArrayList<String>();
        if(you instanceof Character){
            popUp.add(((Character) you).getInventory().getSelectedDisposableItem().getDescription());
            listenerBaseData.mainPanelGame.getGamePanel().setInformationPanelText(popUp);
        }

    }
}
