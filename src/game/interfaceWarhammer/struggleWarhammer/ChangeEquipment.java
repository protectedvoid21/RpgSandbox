package game.interfaceWarhammer.struggleWarhammer;

import game.creature.Character;
import game.creature.Creature;
import game.equipment.Armor;
import game.equipment.Item;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.interfaceWarhammer.StruggleAtributeEnum;
import game.struggle.Action;

public class ChangeEquipment extends Action {

    private  int actionCost = 1;
    private boolean effectOnEnemy = false;
    private boolean needBeCharacter = true;

    @Override
    public void doAction(Creature you, Item item) {
        if (you instanceof Character){

            if(item instanceof Weapon){
                ((Character) you).getInventory().setActiveWeapon((Weapon) item);
            } else if(item instanceof Armor){
                ((Character) you).getInventory().setActiveArmor((Armor) item);
            } else if(item instanceof Mount){
                ((Character) you).getInventory().setActiveMount((Mount) item);
            }
        }

        you.getStruggleStatistics().getAttribute(StruggleAtributeEnum.ACTIONS_TO_DO).decreaseValue(actionCost);
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
