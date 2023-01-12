package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class Block extends Action {

    private  int actionCost = 1;
    private boolean effectOnEnemy = false;
    private boolean needBeCharacter = false;

    @Override
    public void doAction(Creature you) {
            you.getStruggleStatistics().getAttribute(IS_BLOKING).setValue(1);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
    }

    public int getActionCost() {
        return actionCost;
    }

    public boolean isNeedBeCharacter() {
        return needBeCharacter;
    }

    public boolean isEffectOnEnemy() {
        return effectOnEnemy;
    }
}
