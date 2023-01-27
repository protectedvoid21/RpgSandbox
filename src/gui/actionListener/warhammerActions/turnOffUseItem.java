package gui.actionListener.warhammerActions;

import game.board.RoundManager;
import game.creature.Character;
import game.creature.Monster;
import game.generals.Vector2;
import game.utils.MathHelper;
import gui.views.gamePanel.MainPanelGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class turnOffUseItem {
    public static void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame) {

        var indexesCell = new ArrayList<>(Arrays.asList(0, 2, 3, 4));
        var indexesOption = new ArrayList<>(Arrays.asList(0, 1, 2));

        for (int i = 0; i < roundManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < roundManager.getBoard().getWidth(); j++) {
                indexesCell = new ArrayList<>(Arrays.asList(0, 2, 3, 4));

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

