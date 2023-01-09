package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;

import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class DefenseStand extends Action {
    private  int actionCost = 2;
    private boolean effectOnEnemy = false;
    private boolean needBeCharacter = false;

    @Override
    public  void doAction(Creature you) {
        if (you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue() == 2) {
            you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStruggleStatistics().getAttribute(IS_IN_DEFENSE_STAND).setValue(1);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).setValue(0);
        }
    }

    @Override
    public int getActionCost() {
        return actionCost;
    }

    @Override
    public boolean isEffectOnEnemy() {
        return effectOnEnemy;
    }

    @Override
    public boolean isNeedBeCharacter() {
        return needBeCharacter;
    }
}
