package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Monster;
import game.generals.Vector2;
import game.utils.MathHelper;
import gui.views.gamePanel.MainPanelGame;

import java.util.ArrayList;
import java.util.List;

public class turnOffUseItem {
    public static void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame) {

        ArrayList<Integer> indexesCell = new ArrayList<Integer>();
        ArrayList<Integer> indexesOption = new ArrayList<Integer>();

        indexesCell.add(0);
        indexesCell.add(2);
        indexesCell.add(3);
        indexesCell.add(4);

        indexesOption.add(0);
        indexesOption.add(1);
        indexesOption.add(2);

        for (int i = 0; i < roundManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < roundManager.getBoard().getWidth(); j++) {
                indexesCell = new ArrayList<Integer>();
                indexesCell.add(0);
                indexesCell.add(2);
                indexesCell.add(3);
                indexesCell.add(4);

                if (roundManager.getBoard().getPlace(new Vector2(j, i)).isEmpty()) { // Sprawdza czy jest postać

                    indexesCell.add(1);
                    indexesCell.add(5);
                }
                mainPanelGame.getGamePanel().setOptionsDisabledIndexes(new Vector2(j, i), indexesCell);
            }

        }

        mainPanelGame.getActivityOptionsPanel().setDisabledIndexes(indexesOption);

    }
}

