package game.struggle;

import game.creature.Creature;
import game.equipment.Item;

public abstract class Action {

    protected  int actionCost;
    protected boolean effectOnEnemy;
    protected boolean needBeCharacter;

    public  void doAction(Creature you, Creature enemy){};
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
