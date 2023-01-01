package game.interfaceWarhammer;

import game.interfaceWarhammer.struggleWarhammer.*;
import game.interfaces.Actions;


public class ActionsWarhammer extends Actions {
    @Override
    protected void initializeActions() {
        actions.put(ActionsEnum.ATTACK, new Attack());
        actions.put(ActionsEnum.CAREFULL_ATTACK, new CarefullAttack());
        actions.put(ActionsEnum.AIMING, new Aiming());
        actions.put(ActionsEnum.RELOAD, new Reload());
        actions.put(ActionsEnum.MULTIPLE_ATTACK, new MultipleAttack());
        actions.put(ActionsEnum.USE_ITEM, new UseItem());
        actions.put(ActionsEnum.CHANGE_EQUIPMENT, new ChangeEquipment());
        actions.put(ActionsEnum.DEFENSE_STAND, new DefenseStand());
        actions.put(ActionsEnum.THROW_SPELL, new DefenseStand());
    }
}
