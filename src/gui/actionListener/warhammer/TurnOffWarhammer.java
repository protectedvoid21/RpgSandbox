package gui.actionListener.warhammer;

import game.board.RoundManager;
import game.interfaceWarhammer.ActionsEnum;
import game.interfaces.ITurnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class TurnOffWarhammer implements ITurnOffButtons {
    @Override
    public void turnOff(RoundManager roundManager, MainPanelGame mainPanelGame, Integer parametr, Integer usedIndex) {
        ArrayList<Integer> indexesBoard = new ArrayList<Integer>();
        ArrayList<Integer> indexesOption = new ArrayList<Integer>();
        int i = 2;
        int j = 0;
        for (ActionsEnum actionsEnum : ActionsEnum.values()) {
            if (roundManager.getActions().getActions().get(actionsEnum).isEffectOnEnemy()) {
                if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                    indexesBoard.add(i);
                }
                i++;
            } else {
                if (roundManager.getActions().getActions().get(actionsEnum).getActionCost() > roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue()) {
                    indexesOption.add(j);
                }
                j++;

            }

            if (parametr == 0){
                if(!indexesBoard.contains(usedIndex))
                indexesBoard.add(usedIndex);
            } else if(parametr == 1){
                if(!indexesOption.contains(usedIndex))
                indexesOption.add(usedIndex);
            }

//            mainPanelGame.getGamePanel().setOptionsDisabledIndexes(indexesBoard);//dodatkowy drugi argument w postaci punkta
            mainPanelGame.getActivityOptionsPanel().setDisabledIndexes(indexesOption);
        }
    }
}
