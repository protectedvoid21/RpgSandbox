package game.interfaces;

import game.creature.Creature;
import game.struggle.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Actions {

    protected Map<IActionsEnum, Action> actions = new HashMap<>();

    public Actions() {
        initializeActions();
    }

    protected abstract void initializeActions();

    public void doAction(IActionsEnum iActionsEnum, Creature you, Creature enemy, ArrayList<String> popUp){
        actions.get(iActionsEnum).doAction(you, enemy,popUp);
    };
    public void doAction(IActionsEnum iActionsEnum, Creature you){
        actions.get(iActionsEnum).doAction(you);
    };

    public Map<IActionsEnum, Action> getActions() {
        return actions;
    }
}
