package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.equipment.Item;
import game.interfaceWarhammer.StruggleAtributeEnum;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.ValidatorItemListener;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.pickers.FullItemPicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EndTurnListener implements ActionListener {

    final private RoundManager roundManager;
    final private MainPanelGame mainPanelGame;
    final private ListenerBaseData listenerBaseData;

    public EndTurnListener(ListenerBaseData listenerBaseData) {
        this.listenerBaseData = listenerBaseData;
        this.roundManager = listenerBaseData.roundManager;
        this.mainPanelGame = listenerBaseData.mainPanelGame;
        itemGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("ssss");
        roundManager.moveToNextObject();
        if(roundManager.getGameObjectWithTurn().getCreature().getStruggleStatistics().getAttribute(StruggleAtributeEnum.IS_BLOKING).getValue()==0){
            listenerBaseData.mainPanelGame.getGamePanel().removeActionContent(roundManager.getGameObjectWithTurnPosition(), GamePanel.ActionsLabelsType.DEFEND);
        }
        mainPanelGame.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(roundManager, mainPanelGame, 2, 0);
        itemGenerator();

    }

    private void uploadPicker(FullItemPicker.LabelType type, List<? extends Item> items, Item activeItem) {
        var array = generatePathsArrayList(items);
        mainPanelGame.getPicker(type).uploadData(array);
        mainPanelGame.getPicker(type).setCurrentIndex(items.
                indexOf(activeItem));
    }

    private void itemGenerator() {
        var creature = roundManager.getGameObjectWithTurn().getCreature();
        boolean validator = creature instanceof Character;
        mainPanelGame.setRightPickersVisibility(validator);
        if (validator) {
            var character = (Character) creature;
            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getMounts(),
                    character.getInventory().getActiveMount());
            uploadPicker(FullItemPicker.LabelType.ARMOR, character.getInventory().getArmors(),
                    character.getInventory().getActiveArmor());
            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getWeapons(),
                    character.getInventory().getActiveWeapon());
            var array = generatePathsArrayList(character.getInventory().getDisposableItems());
            mainPanelGame.getItemsItemPicker().uploadData(array);
            mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));
            ValidatorItemListener.setValid(character, listenerBaseData);
        }
    }

    private ArrayList<String> generatePathsArrayList(List<? extends Item> items) {
        var array = new ArrayList<String>();
        for (var item : items) {
            array.add(item.getItemPathPicture());
        }
        return array;
    }
}
