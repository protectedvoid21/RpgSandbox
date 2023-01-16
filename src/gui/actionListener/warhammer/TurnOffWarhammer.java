package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.generals.Vector2;
import game.interfaceWarhammer.ActionsEnum;
import game.interfaces.ITurnOffButtons;
import game.utils.MathHelper;
import gui.views.gamePanel.MainPanelGame;

import java.util.List;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class TurnOffWarhammer implements ITurnOffButtons {
    @Override
    public void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame, Integer parametr, Integer usedIndex) {
        ArrayList<Integer> indexesCell = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> indexesBoard = new ArrayList<>();
        ArrayList<Integer> indexesOption = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int n = 2;
        int m = 0;


        List<Vector2> range = MathHelper.getGridCircle(roundManager.getGameObjectWithTurn().getCreature().getSpeed());
        List<Vector2> atackRange = MathHelper.getNextCels(roundManager.getGameObjectWithTurnPosition());
        for (i = 0; i < roundManager.getBoard().getHeigt(); i++) {
            for (j = 0; j < roundManager.getBoard().getWidth(); i++) {
                if (range.contains(new Vector2(j, i))) { // Sprawdza zasięg chodzenia
                    if (indexesCell.contains(0)) {
                        indexesCell.remove(0);
                    }
                } else if (!indexesCell.contains(0)) {
                    indexesCell.add(0);
                }

                if (atackRange.contains(new Vector2(j, i))) {  // Sprawdza zasieg ataku
                    if (indexesCell.contains(2)) {
                        indexesCell.remove(2);
                        indexesCell.remove(3);
                        indexesCell.remove(4);
                    }
                } else if (!indexesCell.contains(2)) {
                    indexesCell.add(2);
                    indexesCell.add(3);
                    indexesCell.add(4);
                }

                if (roundManager.getBoard().getPlace(new Vector2(j, i)).isEmpty()) { // Sprawdza czy jest postać
                    if (!indexesCell.contains(1)) {
                        indexesCell.add(1);
                    }
                } else if (indexesCell.contains(1)) {
                    indexesCell.remove(1);
                }

                n = 2;
                m = 0;
                for (ActionsEnum actionsEnum : ActionsEnum.values()) {
                    if (roundManager.getActions().getActions().get(actionsEnum).isEffectOnEnemy()) {
                        if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                            indexesCell.add(i);
                        }
                        n++;
                    } else {
                        if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                            indexesOption.add(j);
                        }
                        m++;

                    }

                }

                indexesBoard.add(indexesCell);
            }


        }


        if (parametr == 0) {
            if (!indexesBoard.contains(usedIndex))
                indexesCell.add(usedIndex);
        } else if (parametr == 1) {
            if (!indexesOption.contains(usedIndex))
                indexesOption.add(usedIndex);
        }



        mainPanelGame.getActivityOptionsPanel().setDisabledIndexes(indexesOption);
    }
}


