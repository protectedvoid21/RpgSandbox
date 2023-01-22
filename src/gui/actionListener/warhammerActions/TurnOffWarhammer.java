package gui.actionListener.warhammerActions;

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
        ArrayList<Integer> indexesOption = new ArrayList<Integer>();

        int n;
        int m;


        List<Vector2> range = MathHelper.getGridCircle(roundManager.getGameObjectWithTurn().getCreature().getSpeed(),
                roundManager.getGameObjectWithTurnPosition());
        List<Vector2> attackRange = MathHelper.getNextCells(roundManager.getGameObjectWithTurnPosition());


        for (int i = 0; i < roundManager.getBoard().getHeight(); i++) {
            for (int j = 0; j < roundManager.getBoard().getWidth(); j++) {
                indexesCell = new ArrayList<Integer>();

                if (!range.contains(new Vector2(j, i))) { // Sprawdza zasięg chodzenia

                    indexesCell.add(0);

                }

                if (!attackRange.contains(new Vector2(j, i))) {  // Sprawdza zasieg ataku

                    indexesCell.add(2);
                    indexesCell.add(3);
                    indexesCell.add(4);
                }

                if (roundManager.getBoard().getPlace(new Vector2(j, i)).isEmpty()) { // Sprawdza czy jest postać

                    indexesCell.add(1);
                    if(!indexesCell.contains(2)){
                        indexesCell.add(2);
                        indexesCell.add(3);
                        indexesCell.add(4);
                    }
                }


                n = 2;
                m = 0;
                for (ActionsEnum actionsEnum : ActionsEnum.values()) {
                    System.out.println(actionsEnum);
                    System.out.println(roundManager.getActions().getActions());
                    if (roundManager.getActions().getActions().get(actionsEnum).isEffectOnEnemy()) {

                        if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                            if (!indexesCell.contains(n))
                                indexesCell.add(n);
                        }
                        n++;
                    } else {
                        if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                            if (!indexesOption.contains(m))
                                indexesOption.add(m);
                        }
                        m++;

                    }

                }

                if (roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue() == 0){
                    if (!indexesCell.contains(0)){
                        indexesCell.add(0);
                    }
                }
                if (parametr == 0) {
                    if (!indexesCell.contains(usedIndex))
                        indexesCell.add(usedIndex);
                }

                mainPanelGame.getGamePanel().setOptionsDisabledIndexes(new Vector2(j, i), indexesCell);


            }

                if (parametr == 1) {
                    if (!indexesOption.contains(usedIndex))
                        indexesOption.add(usedIndex);
                }

                mainPanelGame.getActivityOptionsPanel().setDisabledIndexes(indexesOption);
        }
    }
}


