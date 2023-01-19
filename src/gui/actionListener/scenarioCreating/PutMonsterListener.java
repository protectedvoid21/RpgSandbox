package gui.actionListener.scenarioCreating;

import game.board.GameObject;
import game.board.RoundManager;
import game.creature.Monster;
import gui.views.gamePanel.MainPanelGame;
import gui.views.objectViews.creationViews.CreatorGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PutMonsterListener implements ActionListener {

    RoundManager roundManager;

    CreatorGameView creatorGameView;
    ArrayList<Monster> mockMonsters;
    int index;

    public PutMonsterListener(RoundManager roundManager, CreatorGameView creatorGameView, int index, ArrayList<Monster> mockMonsters) {
        this.roundManager = roundManager;
        this.creatorGameView = creatorGameView;
        this.index = index;
        this.mockMonsters = mockMonsters;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.getBoard().getPlace(creatorGameView.getCreatorPanel().getCurrentClickedIndexes()).setGameObject(new GameObject(mockMonsters.get(index)));
        creatorGameView.getCreatorPanel().applyNewCreatureOnPosition(mockMonsters.get(index).getObjectPathPicture(),creatorGameView.getCreatorPanel().getCurrentClickedIndexes());
    }
}
