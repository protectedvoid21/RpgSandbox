package gui.actionListener.scenarioCreating;

import game.board.GameObject;
import game.board.RoundManager;
import game.creature.Monster;
import game.creature.NPC;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutNPCListener implements ActionListener {

    RoundManager roundManager;

    CreatorGameView creatorGameView;
    ArrayList<NPC> mockNPC;
    int index;

    public PutNPCListener(RoundManager roundManager, CreatorGameView creatorGameView, int index, ArrayList<NPC> mockNPC) {
        this.roundManager = roundManager;
        this.creatorGameView = creatorGameView;
        this.index = index;
        this.mockNPC = mockNPC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.getBoard().getPlace(creatorGameView.getCreatorPanel().getCurrentClickedIndexes()).setGameObject(new GameObject(mockNPC.get(index)));
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(mockNPC.get(index).getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
