package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class Aiming extends Action {

    private  int actionCost = 1;
    private boolean effectOnEnemy = false;
    private boolean needBeCharacter = false;


        @Override
        public  void doAction(Creature you) {
        if (0 == you.getStruggleStatistics().getAttribute(IS_AIMING).getValue()) {
            you.getStruggleStatistics().getAttribute(IS_AIMING).setValue(1);
            you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        } // else do zrobienia w gui
    }

    public int getActionCost() {
        return actionCost;
    }

    public boolean isEffectOnEnemy() {
        return effectOnEnemy;
    }

    public boolean isNeedBeCharacter() {
        return needBeCharacter;
    }
}
