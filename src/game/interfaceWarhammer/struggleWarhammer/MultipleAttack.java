package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.struggle.Action;

import java.util.ArrayList;

import static game.interfaceWarhammer.AttributeEnum.*;
import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class MultipleAttack extends Attack {

    private  int actionCost = 2;
    private boolean effectOnEnemy = true;
    private boolean needBeCharacter = false;
    @Override
    public void doAction(Creature you, Creature enemy, ArrayList<String> popUp) {
        for (int i = 0; i < you.getStatistics().getAttribute(ATTACKS).getValue(); i++){
            super.doAction(you, enemy,popUp);
        }

        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).setValue(0);
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
