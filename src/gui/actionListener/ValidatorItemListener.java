package gui.actionListener;

import game.creature.Character;
import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;
public class ValidatorItemListener {

    public static void setValid(Character character, ListenerBaseData listenerBaseData) {
        var item = character.getInventory().getSelectedDisposableItem();
        listenerBaseData.mainPanelGame.getItemsItemPicker().setButtonEnability((item != null && item.isValid() &&
                !(listenerBaseData.roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(ACTIONS_TO_DO).getValue() == 0)));
    }
}
