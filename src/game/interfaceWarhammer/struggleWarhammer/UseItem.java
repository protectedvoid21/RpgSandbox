package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Creature;
import game.equipment.DisposableItem;
import game.equipment.Item;
import game.interfaceWarhammer.StruggleAtributeEnum;
import game.struggle.Action;

public class UseItem extends Action {
    private  int actionCost = 1;
    private boolean effectOnEnemy = false;
    private boolean needBeCharacter = false;

    @Override
    public void doAction(Creature you, Item item) {

        if (item instanceof DisposableItem){
            ((DisposableItem) item).use();
            you.getStruggleStatistics().getAttribute(StruggleAtributeEnum.ACTIONS_TO_DO).decreaseValue(actionCost);
        }
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
