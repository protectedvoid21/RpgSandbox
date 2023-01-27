package gui.actionListener.basicActionsListener;

import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowDescripton implements ActionListener {
    private final ListenerBaseData listenerBaseData;
    public ShowDescripton(ListenerBaseData listenerBaseData) {
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
