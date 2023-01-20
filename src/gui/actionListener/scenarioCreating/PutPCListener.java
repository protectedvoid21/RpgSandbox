package gui.actionListener.scenarioCreating;

import game.board.GameObject;
import game.board.RoundManager;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutPCListener implements ActionListener {

    RoundManager roundManager;

    CreatorGameView creatorGameView;
    ArrayList<PlayerCharacter> mockPC;
    int index;

    public PutPCListener(RoundManager roundManager, CreatorGameView creatorGameView, int index, ArrayList<PlayerCharacter> mockPC) {
        this.roundManager = roundManager;
        this.creatorGameView = creatorGameView;
        this.index = index;
        this.mockPC = mockPC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.getBoard().getPlace(creatorGameView.getCreatorPanel().getCurrentClickedIndexes()).setGameObject(new GameObject(mockPC.get(index)));
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(mockPC.get(index).getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
