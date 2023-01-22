package game.struggle;

import game.creature.Creature;
import game.equipment.Item;

import java.util.ArrayList;

public abstract class Action {

    protected  int actionCost;
    protected boolean effectOnEnemy;
    protected boolean needBeCharacter;

    public  void doAction(Creature you, Creature enemy, ArrayList<String> popUp){};
    public void doAction(Creature you){};
    public void doAction(Creature you, Item item){};

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
